/*import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class _2178 {
    static int N, M;
    static int[][] maze;
    static boolean[][] visited;
    static int[][] distance;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        scanner.nextLine(); 
        
        maze = new int[N][M];
        visited = new boolean[N][M];
        distance = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        scanner.close();
        
        bfs(0, 0);
        System.out.println(distance[N - 1][M - 1]);
    }
    
    static void bfs(int startX, int startY) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startX, startY));
        visited[startX][startY] = true;
        distance[startX][startY] = 1;
        
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];
                
                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
                    if (maze[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                        queue.add(new Point(nextX, nextY));
                        visited[nextX][nextY] = true;
                        distance[nextX][nextY] = distance[current.x][current.y] + 1;
                    }
                }
            }
        }
    }
}
*/