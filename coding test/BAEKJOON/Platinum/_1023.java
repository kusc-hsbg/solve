import java.util.Arrays;
import java.util.Scanner;

public class _1023 {
    static long N, K;
    static long[][][] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextLong();
        K = scanner.nextLong();
        scanner.close();

        dp = new long[55][55][2];
        for (long[][] arr2d : dp) {
            for (long[] arr1d : arr2d) {
                Arrays.fill(arr1d, -1);
            }
        }

        if (solve(0, 0, 0, false) < K + 1) {
            System.out.println(-1);
        } else {
            trackAnswer(0, 0, 0, false, K + 1);
        }
    }

    private static long subSolve(int length, int cnt) {
        if (N < length || N < cnt) return 0;
        if (dp[length][cnt][1] != -1) return dp[length][cnt][1];
        if (length == N) return dp[length][cnt][1] = 1;

        return dp[length][cnt][1] = subSolve(length + 1, cnt) + subSolve(length + 1, cnt + 1);
    }

    private static long solve(int length, int cnt, int check, boolean nono) {
        if (N < length || N < cnt) return 0;
        if (dp[length][cnt][0] != -1) return dp[length][cnt][0];

        if (length == N) {
            if (check == 0) return 0;
            else return dp[length][cnt][0] = 1;
        }

        if (check < 0) nono = true;

        if (nono) {
            return dp[length][cnt][0] = subSolve(length + 1, cnt) + subSolve(length + 1, cnt + 1);
        }

        return dp[length][cnt][0] = solve(length + 1, cnt, check + 1, nono) + solve(length + 1, cnt + 1, check - 1, nono);
    }

    private static void trackAnswer(int length, int cnt, int check, boolean nono, long nth) {
        if (length == N) return;

        if (check < 0) nono = true;

        if (dp[length + 1][cnt][nono ? 1 : 0] < nth) {
            System.out.print(')');
            trackAnswer(length + 1, cnt + 1, check - 1, nono, nth - dp[length + 1][cnt][nono ? 1 : 0]);
        } else {
            System.out.print('(');
            trackAnswer(length + 1, cnt, check + 1, nono, nth);
        }
    }
}
