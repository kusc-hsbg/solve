import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class _2098 {
    private static final int INF = Integer.MAX_VALUE / 2;
    private static int[][] W;
    private static int N;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[1 << N][N];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int result = tsp(1, 0);
        System.out.println(result);
    }

    private static int tsp(int mask, int pos) {
        if (mask == (1 << N) - 1) {
            return W[pos][0] > 0 ? W[pos][0] : INF;
        }

        if (dp[mask][pos] != -1) {
            return dp[mask][pos];
        }

        int result = INF;
        for (int city = 0; city < N; city++) {
            if ((mask & (1 << city)) == 0 && W[pos][city] > 0) {
                int newCost = W[pos][city] + tsp(mask | (1 << city), city);
                result = Math.min(result, newCost);
            }
        }
        dp[mask][pos] = result;
        return result;
    }
}
