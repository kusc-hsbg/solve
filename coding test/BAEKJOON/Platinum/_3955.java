import java.util.Scanner;

public class _3955 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();

            for (int i = 0; i < t; i++) {
                long K = scanner.nextLong();
                long C = scanner.nextLong();

                if (C == 1) {
                    if (K + 1 > 1000000000) {
                        System.out.println("IMPOSSIBLE");
                    } else {
                        System.out.println(K + 1);
                    }
                    continue;
                }

                if (K == 1) {
                    System.out.println(1);
                    continue;
                }

                long[] result = extendedGCD(C, K);
                long g = result[0], x = result[1];

                if (g != 1) {
                    System.out.println("IMPOSSIBLE");
                } else {
                    x = (x % K + K) % K;
                    if (x > 1000000000) {
                        System.out.println("IMPOSSIBLE");
                    } else {
                        System.out.println(x);
                    }
                }
            }
        }
    }

    private static long[] extendedGCD(long a, long b) {
        if (b == 0) {
            return new long[]{a, 1, 0};
        }
        long[] vals = extendedGCD(b, a % b);
        long g = vals[0], x = vals[2], y = vals[1] - (a / b) * vals[2];
        return new long[]{g, x, y};
    }
}
