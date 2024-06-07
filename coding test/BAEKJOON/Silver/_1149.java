import java.util.Scanner;

public class _1149 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            int[][] cost = new int[N+1][3];
            int[][] dp = new int[N+1][3];
            
            for (int i = 1; i <= N; i++) {
                cost[i][0] = scanner.nextInt();
                cost[i][1] = scanner.nextInt();
                cost[i][2] = scanner.nextInt();
            }
            
            dp[1][0] = cost[1][0];
            dp[1][1] = cost[1][1];
            dp[1][2] = cost[1][2];
            
            for (int i = 2; i <= N; i++) {
                dp[i][0] = cost[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
                dp[i][1] = cost[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
                dp[i][2] = cost[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
            }
            
            int result = Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2]));
            System.out.println(result);
        }
    }
}
