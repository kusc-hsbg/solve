import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _10026 {
    static int N;
    static char[][] map;
    static boolean[][] visited;
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int normalCount = countRegions(false);
        int colorBlindCount = countRegions(true);

        System.out.println(normalCount + " " + colorBlindCount);
    }

    private static int countRegions(boolean isColorBlind) {
        int count = 0;
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, isColorBlind);
                    count++;
                }
            }
        }
        return count;
    }

    private static void bfs(int x, int y, boolean isColorBlind) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        char color = map[x][y];

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                    if (isColorBlind) {
                        if (color == 'R' || color == 'G') {
                            if (map[nx][ny] == 'R' || map[nx][ny] == 'G') {
                                visited[nx][ny] = true;
                                queue.add(new int[]{nx, ny});
                            }
                        } else if (map[nx][ny] == color) {
                            visited[nx][ny] = true;
                            queue.add(new int[]{nx, ny});
                        }
                    } else {
                        if (map[nx][ny] == color) {
                            visited[nx][ny] = true;
                            queue.add(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
    }
}
