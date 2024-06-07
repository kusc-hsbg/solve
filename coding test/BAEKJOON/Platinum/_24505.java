import java.util.Scanner;

public class _24505 {
    static final int N = 100001;
    static final int MOD = 1000000007;
    static int[][] seg = new int[12][N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int n = scanner.nextInt();

            for (int i = 1; i <= n; i++) {
                int x = scanner.nextInt();
                update(1, x, 1);
                for (int k = 2; k < 12; k++) {
                    int val = query(k - 1, x - 1);
                    update(k, x, val);
                }
            }

            int result = query(11, N - 1); // 최종 결과를 계산합니다.
            System.out.println(result);
        } finally {
            scanner.close(); // 스캐너를 닫습니다.
        }
    }

    static void update(int u, int x, int val) {
        for (; x < N; x += x & -x) {
            seg[u][x] += val;
            if (seg[u][x] >= MOD) {
                seg[u][x] -= MOD;
            }
        }
    }

    static int query(int u, int x) {
        int res = 0;
        for (; x > 0; x -= x & -x) {
            res += seg[u][x];
            if (res >= MOD) {
                res -= MOD;
            }
        }
        return res;
    }
}
