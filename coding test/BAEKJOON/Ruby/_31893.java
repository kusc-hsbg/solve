import java.util.*;

public class _31893 {
    public static void solve() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = scanner.nextInt();
        long[] t = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            t[i] = scanner.nextLong();
        }
        Arrays.sort(t, 1, n + 1);
        scanner.close();

        if (n <= c) {
            System.out.println(t[n]);
            return;
        }

        long[][] dp = new long[n + 1][(n - 2) / c + 1];

        for (int i = 2; i <= c; i++) {
            dp[i][0] = t[i];
        }

        for (int i = 2; i <= n; i++) {
            t[i] += t[i - 1];
        }

        for (int i = 2; i <= c; i++) {
            for (int j = 1; j <= (n - 2) / c; j++) {
                int p = Math.min(i, j + 1);
                dp[i][j] = dp[p][j - p + 1] + t[p] + t[i] - t[i - 1];
                for (int k = p - 1; k >= 2; k--) {
                    dp[i][j] = Math.min(dp[i][j], dp[k][j - k + 1] + t[k] + t[i] - t[i - 1]);
                }
            }
        }

        for (int j = 0; j <= (n - 2) / c; j++) {
            dp[c + 1][j] = dp[2][j] + t[c + 1] - t[c] + t[1];
            for (int k = 2; k <= Math.min(j + 1, c - 1); k++) {
                dp[c + 1][j] = Math.min(dp[c + 1][j], dp[k + 1][j - k + 1] + t[k] + t[c + 1] - t[c]);
            }
        }

        for (int i = c + 2; i <= n; i++) {
            for (int j = 0; j <= (n - i) / c; j++) {
                dp[i][j] = dp[i - c][j + 1] + t[i] - t[i - 1];
                for (int k = 1; k <= Math.min(j + 1, c - 1); k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - c + k][j - k + 1] + t[k] + t[i] - t[i - 1]);
                }
            }
        }

        System.out.println(dp[n][0]);
    }

    public static void main(String[] args) {
        solve();
    }
}
