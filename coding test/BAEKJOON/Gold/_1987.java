import java.util.Scanner;

public class _1987 {
    static int R, C;
    static char[][] board;
    static boolean[] visited;
    static int maxCount = 0;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        R = scanner.nextInt();
        C = scanner.nextInt();
        scanner.nextLine();

        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            board[i] = scanner.nextLine().toCharArray();
        }

        scanner.close();
        
        visited = new boolean[26];
        dfs(0, 0, 1);
        
        System.out.println(maxCount);
    }
    
    public static void dfs(int x, int y, int count) {
        visited[board[x][y] - 'A'] = true;
        maxCount = Math.max(maxCount, count);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                if (!visited[board[nx][ny] - 'A']) {
                    dfs(nx, ny, count + 1);
                }
            }
        }

        visited[board[x][y] - 'A'] = false;
    }
}
