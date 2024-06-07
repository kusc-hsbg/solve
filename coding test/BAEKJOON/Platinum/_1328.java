import java.util.Scanner;

public class _1328 {
    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            int L = scanner.nextInt();
            int R = scanner.nextInt();

            long[][][] dp = new long[N + 1][L + 1][R + 1];
            dp[1][1][1] = 1;

            for (int n = 2; n <= N; n++) {
                for (int l = 1; l <= L; l++) {
                    for (int r = 1; r <= R; r++) {
                        dp[n][l][r] = (dp[n - 1][l - 1][r]
                                     + dp[n - 1][l][r - 1]
                                     + (dp[n - 1][l][r] * (n - 2)) % MOD) % MOD;
                    }
                }
            }
            System.out.println(dp[N][L][R]);
        }
    }
}
