import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7576 {

    private static final int[] dx = {0, 0, -1, 1}; 
    private static final int[] dy = {1, -1, 0, 0}; 

    private static int[][] tomatoes;
    private static int M;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); 
        N = Integer.parseInt(st.nextToken()); 

        tomatoes = new int[N][M];
        Queue<Tomato> queue = new LinkedList<>();
        int totalTomatoes = 0;
        int ripeTomatoes = 0;

        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                tomatoes[y][x] = Integer.parseInt(st.nextToken());
                if (tomatoes[y][x] == 1) {
                    queue.add(new Tomato(x, y, 0));
                    ripeTomatoes++;
                }
                if (tomatoes[y][x] != -1) {
                    totalTomatoes++;
                }
            }
        }

        if (ripeTomatoes == totalTomatoes) {
            System.out.println(0);
            return;
        }

        int days = bfs(queue);

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (tomatoes[y][x] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(days);
    }

    private static int bfs(Queue<Tomato> queue) {
        int days = 0;
        while (!queue.isEmpty()) {
            Tomato tomato = queue.poll();
            days = tomato.day;

            for (int i = 0; i < 4; i++) {
                int nx = tomato.x + dx[i];
                int ny = tomato.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < M && ny < N && tomatoes[ny][nx] == 0) {
                    tomatoes[ny][nx] = 1;
                    queue.add(new Tomato(nx, ny, days + 1));
                }
            }
        }
        return days;
    }

    private static class Tomato {
        int x, y, day;

        public Tomato(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }
}
