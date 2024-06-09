import java.util.Scanner;

public class _1052 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        scanner.close();

        if (K >= N) {
            System.out.println(0);
            return;
        }

        int extraBottles = 0;
        while (Integer.bitCount(N) > K) {
            int lowestBit = N & -N;
            N += lowestBit;
            extraBottles += lowestBit;
        }

        System.out.println(extraBottles);
    }
}