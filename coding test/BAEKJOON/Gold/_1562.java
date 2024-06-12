import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class _1562 {
    static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][][] dp = new long[N + 1][10][1 << 10];

        for (int digit = 1; digit <= 9; digit++) {
            dp[1][digit][1 << digit] = 1;
        }

        for (int length = 1; length < N; length++) {
            for (int digit = 0; digit <= 9; digit++) {
                for (int mask = 0; mask < (1 << 10); mask++) {
                    if (dp[length][digit][mask] > 0) {
                        if (digit > 0) {
                            int newMask = mask | (1 << (digit - 1));
                            dp[length + 1][digit - 1][newMask] = (dp[length + 1][digit - 1][newMask] + dp[length][digit][mask]) % MOD;
                        }
                        if (digit < 9) {
                            int newMask = mask | (1 << (digit + 1));
                            dp[length + 1][digit + 1][newMask] = (dp[length + 1][digit + 1][newMask] + dp[length][digit][mask]) % MOD;
                        }
                    }
                }
            }
        }

        long result = 0;
        int fullMask = (1 << 10) - 1;

        for (int digit = 0; digit <= 9; digit++) {
            result = (result + dp[N][digit][fullMask]) % MOD;
        }

        System.out.println(result);
    }
}
