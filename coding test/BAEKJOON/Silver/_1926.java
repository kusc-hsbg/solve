import java.io.*;
import java.util.*;

public class _1926 {
    static int n, m;
    static int[][] canvas;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1}; // 상, 하, 좌, 우 방향
    static int[] dy = {-1, 1, 0, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        canvas = new int[n][m];
        visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                canvas[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int numberOfPictures = 0;
        int maxArea = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (canvas[i][j] == 1 && !visited[i][j]) {
                    numberOfPictures++;
                    int area = dfs(i, j);
                    if (area > maxArea) {
                        maxArea = area;
                    }
                }
            }
        }
        
        System.out.println(numberOfPictures);
        System.out.println(maxArea);
    }
    
    static int dfs(int x, int y) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {x, y});
        visited[x][y] = true;
        int area = 0;
        
        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int cx = current[0];
            int cy = current[1];
            area++;
            
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (canvas[nx][ny] == 1 && !visited[nx][ny]) {
                        stack.push(new int[] {nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        
        return area;
    }
}
