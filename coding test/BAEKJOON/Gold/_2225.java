import java.io.*;
import java.util.*;

public class _2225 {
    static final int MOD = 1_000_000_000;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[][] dp = new int[N+1][K+1];
        dp[0][0] = 1;
        
        for (int j = 1; j <= K; j++) {
            for (int i = 0; i <= N; i++) {
                dp[i][j] = dp[i][j-1];
                if (i > 0) {
                    dp[i][j] += dp[i-1][j];
                    dp[i][j] %= MOD;
                }
                if (i > N) {
                    dp[i][j] -= dp[i-N-1][j-1];
                    if (dp[i][j] < 0) {
                        dp[i][j] += MOD;
                    }
                }
            }
        }
        
        System.out.println(dp[N][K]);
    }
}
