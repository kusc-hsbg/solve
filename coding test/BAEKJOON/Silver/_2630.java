import java.util.Scanner;

public class _2630 {
    static int[][] map;
    static int w_cnt = 0, b_cnt = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        map = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        scanner.close();
        
        divConq(0, 0, n);
        
        System.out.println(w_cnt);
        System.out.println(b_cnt);
    }

    static void divConq(int x, int y, int N) {
        int tmp_cnt = 0;
        for (int i = x; i < x + N; i++) {
            for (int j = y; j < y + N; j++) {
                if (map[i][j] == 1) {
                    tmp_cnt++;
                }
            }
        }

        if (tmp_cnt == 0) {
            w_cnt++;
        } else if (tmp_cnt == N * N) {
            b_cnt++;
        } else {
            int newSize = N / 2;
            divConq(x, y, newSize);
            divConq(x, y + newSize, newSize);
            divConq(x + newSize, y, newSize);
            divConq(x + newSize, y + newSize, newSize);
        }
    }
}
