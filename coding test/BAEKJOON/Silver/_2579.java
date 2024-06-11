import java.util.Scanner;

public class _2579 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[] score = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            score[i] = scanner.nextInt();
        }
        
        scanner.close();
        
        if (n == 1) {
            System.out.println(score[1]);
            return;
        }
        
        int[] dp = new int[n + 1];
        dp[1] = score[1];
        dp[2] = score[1] + score[2];
        
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i-2] + score[i], dp[i-3] + score[i-1] + score[i]);
        }
        
        System.out.println(dp[n]);
    }
}
