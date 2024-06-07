import java.util.Scanner;

public class _1189 {
    private static int R, C, K;
    private static char[][] map;
    private static boolean[][] visited;
    private static int count = 0;

    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            R = scanner.nextInt();
            C = scanner.nextInt();
            K = scanner.nextInt();
            scanner.nextLine();

            map = new char[R][C];
            visited = new boolean[R][C];

            for (int i = 0; i < R; i++) {
                String line = scanner.nextLine();
                for (int j = 0; j < C; j++) {
                    map[i][j] = line.charAt(j);
                }
            }

            visited[R-1][0] = true;
            dfs(R-1, 0, 1);
            
            System.out.println(count);
        }
    }

    private static void dfs(int x, int y, int dist) {
        if (x == 0 && y == C - 1) {
            if (dist == K) {
                count++;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nx][ny] && map[nx][ny] == '.') {
                visited[nx][ny] = true;
                dfs(nx, ny, dist + 1);
                visited[nx][ny] = false;
            }
        }
    }
}
