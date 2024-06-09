import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2447 {
    static char[][] pattern;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        pattern = new char[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                pattern[i][j] = ' ';
            }
        }

        generatePattern(0, 0, N);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(pattern[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }

    private static void generatePattern(int x, int y, int size) {
        if (size == 1) {
            pattern[x][y] = '*';
            return;
        }

        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                generatePattern(x + i * newSize, y + j * newSize, newSize);
            }
        }
    }
}
