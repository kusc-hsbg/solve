import java.io.*;
import java.util.*;

public class _2206 {
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        String[] grid = new String[n];
        for (int i = 0; i < n; i++) {
            grid[i] = br.readLine();
        }

        boolean[][][] visited = new boolean[2][n][m];
        System.out.println(bfs(grid, visited, n, m));
    }

    static int bfs(String[] grid, boolean[][][] visited, int n, int m) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, 0});
        visited[0][0][0] = true;
        int steps = 0;

        while (!queue.isEmpty()) {
            steps++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0], y = current[1], wallRemoved = current[2];

                if (x == n - 1 && y == m - 1) return steps;

                for (int dir = 0; dir < 4; dir++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                        if (!visited[wallRemoved][nx][ny]) {
                            visited[wallRemoved][nx][ny] = true;
                            if (grid[nx].charAt(ny) == '0') {
                                queue.offer(new int[]{nx, ny, wallRemoved});
                            } else if (wallRemoved == 0) {
                                queue.offer(new int[]{nx, ny, 1});
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
}
