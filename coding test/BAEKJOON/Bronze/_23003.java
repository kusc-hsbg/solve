import java.util.Scanner;

public class _23003 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            String S = scanner.next();
            int[] dp = new int[N];
            dp[0] = 1;
            System.out.print("Case #" + t + ": ");
            System.out.print(dp[0]);
            for (int i = 1; i < N; i++) {
                if (S.charAt(i) > S.charAt(i - 1)) {
                    dp[i] = dp[i - 1] + 1;
                } else {
                    dp[i] = 1;
                }
                System.out.print(" " + dp[i]);
            }
            System.out.println();
        }
        scanner.close();
    }
}
