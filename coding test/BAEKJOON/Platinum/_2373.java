import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class _2373 {
    private static final int MAX_N = 1000001;
    private static int[] zSequence = new int[MAX_N];
    private static ArrayList<Integer> fibonacci = new ArrayList<>();
    public static void main(String[] args) {
        generateZSequence();
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        System.out.println(getAnswer(N));
        scanner.close();
    }
    private static void generateZSequence() {
        Arrays.fill(zSequence, 0);
        int fibCurrent = 1, fibNext = 2;
        while (true) {
            fibonacci.add(fibCurrent);
            zSequence[fibCurrent] = fibCurrent;
            zSequence[fibNext] = fibNext;
            int next1 = fibNext;
            int next2 = fibCurrent + fibNext;
            fibCurrent = next1;
            fibNext = next2;
            if (fibCurrent >= MAX_N || fibNext >= MAX_N) break;
        }
        int lastNonZeroIndex = 3;
        for (int i = 4; i < MAX_N; i++) {
            if (zSequence[i] != 0) {
                lastNonZeroIndex = i;
            } else {
                zSequence[i] = zSequence[i - lastNonZeroIndex];
            }
        }
    }
    private static int getAnswer(int n) {
        for (int i = 0; i < fibonacci.size() - 1; i++) {
            if (n == fibonacci.get(i) || n == fibonacci.get(i + 1)) return -1;
            if (fibonacci.get(i) < n && n < fibonacci.get(i + 1)) return zSequence[n % fibonacci.get(i)];
        }
        return zSequence[n % fibonacci.get(fibonacci.size() - 1)];
    }
}