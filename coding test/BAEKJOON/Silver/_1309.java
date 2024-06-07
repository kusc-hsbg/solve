import java.util.Scanner;

public class _1309 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            final int MOD = 9901;

            int[][] dp = new int[N + 1][3];

            dp[1][0] = 1;
            dp[1][1] = 1;
            dp[1][2] = 1;

            for (int i = 2; i <= N; i++) {
                dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % MOD;
                dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % MOD;
                dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % MOD;
            }

            int result = (dp[N][0] + dp[N][1] + dp[N][2]) % MOD;
            System.out.println(result);
        }
    }
}