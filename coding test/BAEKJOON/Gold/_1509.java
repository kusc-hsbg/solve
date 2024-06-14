import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1509 {
    static String text;
    static int N;
    static boolean[][] isPalindrome;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        text = br.readLine();
        N = text.length();
        text = "#" + text; 

        isPalindrome = new boolean[N + 1][N + 1];
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            isPalindrome[i][i] = true;
        }

        for (int length = 2; length <= N; length++) {
            for (int i = 1; i <= N - length + 1; i++) {
                int j = i + length - 1;
                if (text.charAt(i) == text.charAt(j)) {
                    if (length == 2 || isPalindrome[i + 1][j - 1]) {
                        isPalindrome[i][j] = true;
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            dp[i] = Integer.MAX_VALUE; 
            for (int j = 1; j <= i; j++) {
                if (isPalindrome[j][i]) {
                    if (j == 1) {
                        dp[i] = 1;
                    } else {
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }
        }

        System.out.println(dp[N]);
    }
}