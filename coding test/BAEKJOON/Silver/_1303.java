import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _1303 {
    private static int N, M;
    private static char[][] battlefield;
    private static boolean[][] visited;
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            N = scanner.nextInt();
            M = scanner.nextInt();
            scanner.nextLine();

            battlefield = new char[M][N];
            visited = new boolean[M][N];

            for (int i = 0; i < M; i++) {
                String line = scanner.nextLine();
                battlefield[i] = line.toCharArray();
            }

            int whitePower = 0;
            int bluePower = 0;

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        int groupSize = bfs(i, j, battlefield[i][j]);
                        int power = groupSize * groupSize;
                        if (battlefield[i][j] == 'W') {
                            whitePower += power;
                        } else {
                            bluePower += power;
                        }
                    }
                }
            }

            System.out.println(whitePower + " " + bluePower);
        }
    }

    private static int bfs(int x, int y, char team) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            count++;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < M && ny < N && !visited[nx][ny] && battlefield[nx][ny] == team) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }

        return count;
    }
}