import java.util.Scanner;

public class _1074 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int r = scanner.nextInt();
        int c = scanner.nextInt();

        int result = zOrder(N, r, c);
        System.out.println(result);

        scanner.close();
    }

    public static int zOrder(int N, int r, int c) {
        if (N == 0) {
            return 0;
        }

        int half = 1 << (N - 1);

        if (r < half && c < half) {
            return zOrder(N - 1, r, c);
        }
        else if (r < half && c >= half) {
            return half * half + zOrder(N - 1, r, c - half);
        }
        else if (r >= half && c < half) {
            return 2 * half * half + zOrder(N - 1, r - half, c);
        }
        else {
            return 3 * half * half + zOrder(N - 1, r - half, c - half);
        }
    }
}
