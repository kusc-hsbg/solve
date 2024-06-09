import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class _14503 {

    private static int N, M;
    private static int r, c, d;
    private static int[][] room;
    private static boolean[][] cleaned;
    private static int[] dx = {-1, 0, 1, 0}; 
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        room = new int[N][M];
        cleaned = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = cleanRoom();
        System.out.println(result);
    }

    private static int cleanRoom() {
        int count = 0;

        while (true) {
            if (!cleaned[r][c]) {
                cleaned[r][c] = true;
                count++;
            }

            boolean found = false;
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4;
                int nx = r + dx[d];
                int ny = c + dy[d];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && room[nx][ny] == 0 && !cleaned[nx][ny]) {
                    r = nx;
                    c = ny;
                    found = true;
                    break;
                }
            }

            if (!found) {
                int backDirection = (d + 2) % 4;
                int bx = r + dx[backDirection];
                int by = c + dy[backDirection];

                if (bx >= 0 && bx < N && by >= 0 && by < M && room[bx][by] != 1) {
                    r = bx;
                    c = by;
                } else {
                    break;
                }
            }
        }

        return count;
    }
}
