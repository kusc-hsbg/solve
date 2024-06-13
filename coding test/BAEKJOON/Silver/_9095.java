import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] testCases = new int[T];
        
        for (int i = 0; i < T; i++) {
            testCases[i] = Integer.parseInt(br.readLine());
        }
        
        int maxN = 11;
        int[] dp = new int[maxN + 1];
        
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= maxN; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            sb.append(dp[testCases[i]]).append("\n");
        }
        
        System.out.print(sb.toString());
    }
}