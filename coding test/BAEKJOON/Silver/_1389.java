import java.util.Scanner;

public class _1389 {
    static final int INF = 1000000;
    static int N, M;
    static int[][] dist;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            N = scanner.nextInt();
            M = scanner.nextInt();
            dist = new int[N + 1][N + 1];

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i == j) {
                        dist[i][j] = 0;
                    } else {
                        dist[i][j] = INF;
                    }
                }
            }

            for (int i = 0; i < M; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                dist[a][b] = 1;
                dist[b][a] = 1;
            }

            for (int k = 1; k <= N; k++) {
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= N; j++) {
                        if (dist[i][j] > dist[i][k] + dist[k][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                        }
                    }
                }
            }

            int minSum = Integer.MAX_VALUE;
            int person = -1;

            for (int i = 1; i <= N; i++) {
                int sum = 0;
                for (int j = 1; j <= N; j++) {
                    sum += dist[i][j];
                }
                if (sum < minSum) {
                    minSum = sum;
                    person = i;
                }
            }

            System.out.println(person);
        }
    }
}