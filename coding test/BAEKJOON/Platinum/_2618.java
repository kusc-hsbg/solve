import java.io.*;
import java.util.*;

public class _2618 {
    static int N, W;
    static int[][] events;
    static int[][] dp;
    static int[][] path;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        W = Integer.parseInt(reader.readLine());

        events = new int[W + 1][2];
        dp = new int[W + 1][W + 1];
        path = new int[W + 1][W + 1];

        for (int i = 1; i <= W; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            events[i][0] = Integer.parseInt(st.nextToken());
            events[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }

        int minDistance = solve(0, 0);
        System.out.println(minDistance);

        StringBuilder result = new StringBuilder();
        int i = 0, j = 0;
        for (int turn = 1; turn <= W; turn++) {
            if (path[i][j] == 1) {
                result.append(1).append('\n');
                i = turn;
            } else {
                result.append(2).append('\n');
                j = turn;
            }
        }

        System.out.print(result.toString());
    }

    static int solve(int i, int j) {
        if (i == W || j == W) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        int nextEvent = Math.max(i, j) + 1;
        int eventX = events[nextEvent][0];
        int eventY = events[nextEvent][1];

        int car1X = (i == 0) ? 1 : events[i][0];
        int car1Y = (i == 0) ? 1 : events[i][1];
        int car2X = (j == 0) ? N : events[j][0];
        int car2Y = (j == 0) ? N : events[j][1];

        int moveCar1 = Math.abs(car1X - eventX) + Math.abs(car1Y - eventY) + solve(nextEvent, j);
        int moveCar2 = Math.abs(car2X - eventX) + Math.abs(car2Y - eventY) + solve(i, nextEvent);

        if (moveCar1 < moveCar2) {
            dp[i][j] = moveCar1;
            path[i][j] = 1;
        } else {
            dp[i][j] = moveCar2;
            path[i][j] = 2;
        }

        return dp[i][j];
    }
}
