import java.util.Arrays;
import java.util.Scanner;

public class _2342 {
    static final int INF = 1000000000;
    static int[][] dp;
    static int[] steps;
    static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        steps = new int[100001];
        n = 0;

        while (true) {
            int step = scanner.nextInt();
            if (step == 0) break;
            steps[n++] = step;
        }
        scanner.close();

        dp = new int[5][5];
        for (int i = 0; i < 5; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[0][0] = 0;

        for (int i = 0; i < n; i++) {
            int nextStep = steps[i];
            int[][] nextDp = new int[5][5];
            for (int l = 0; l < 5; l++) {
                Arrays.fill(nextDp[l], INF);
            }

            for (int l = 0; l < 5; l++) {
                for (int r = 0; r < 5; r++) {
                    if (dp[l][r] == INF) continue;
                    nextDp[nextStep][r] = Math.min(nextDp[nextStep][r], dp[l][r] + moveCost(l, nextStep));
                    nextDp[l][nextStep] = Math.min(nextDp[l][nextStep], dp[l][r] + moveCost(r, nextStep));
                }
            }

            dp = nextDp;
        }

        int minCost = INF;
        for (int l = 0; l < 5; l++) {
            for (int r = 0; r < 5; r++) {
                minCost = Math.min(minCost, dp[l][r]);
            }
        }

        System.out.println(minCost);
    }

    static int moveCost(int from, int to) {
        if (from == to) return 1;
        if (from == 0) return 2;
        if ((from == 1 && to == 3) || (from == 3 && to == 1) ||
            (from == 2 && to == 4) || (from == 4 && to == 2)) return 4;
        return 3;
    }
}
