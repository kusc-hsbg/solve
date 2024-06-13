import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _21736 {
    static int N, M;
    static char[][] campus;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        N = scanner.nextInt();
        M = scanner.nextInt();
        scanner.nextLine();

        campus = new char[N][M];
        visited = new boolean[N][M];
        int startX = 0, startY = 0;

        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < M; j++) {
                campus[i][j] = line.charAt(j);
                if (campus[i][j] == 'I') {
                    startX = i;
                    startY = j;
                }
            }
        }

        scanner.close();
        int result = bfs(startX, startY);

        if (result == 0) {
            System.out.println("TT");
        } else {
            System.out.println(result);
        }
    }

    private static int bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        int count = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if (campus[x][y] == 'P') {
                count++;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && campus[nx][ny] != 'X' && !visited[nx][ny]) {
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }

        return count;
    }
}
