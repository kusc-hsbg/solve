import java.util.Arrays;
import java.util.Scanner;

public class _1026 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        for (int i = 0; i < N; i++) {
            B[i] = scanner.nextInt();
        }

        Arrays.sort(A);
        Integer[] BDesc = Arrays.stream(B).boxed().toArray(Integer[]::new);
        Arrays.sort(BDesc, (x, y) -> y - x);

        int S = 0;
        for (int i = 0; i < N; i++) {
            S += A[i] * BDesc[i];
        }

        System.out.println(S);
        scanner.close();
    }
}
