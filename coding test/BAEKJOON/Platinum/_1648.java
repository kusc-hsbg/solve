import java.util.*;

public class _1648 {
    static final int MOD = 9901;
    static int N, M;
    static int[][] dp;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            N = scanner.nextInt();
            M = scanner.nextInt();
            dp = new int[1 << N][M + 1];

            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }

            System.out.println(solve(0, 0));
        }
    }

    static int solve(int state, int col) {
        if (col == M) {
            return state == 0 ? 1 : 0;
        }
        if (dp[state][col] != -1) {
            return dp[state][col];
        }

        int result = 0;
        int newState = (~state) & ((1 << N) - 1);

        for (int mask = newState; mask >= 0; mask = (mask - 1) & newState) {
            if (isValid(state, mask)) {
                result = (result + solve(mask, col + 1)) % MOD;
            }
            if (mask == 0) break;
        }

        dp[state][col] = result;
        return result;
    }

    static boolean isValid(int state, int newState) {
        int bits = state | newState;
        for (int i = 0; i < N; i++) {
            if ((bits & (1 << i)) == 0) {
                if (i + 1 < N && (bits & (1 << (i + 1))) == 0) {
                    i++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
