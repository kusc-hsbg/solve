import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class _20531 {
    static final int MOD = 1000000007;
    static int[] parent;
    static int[] rank;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        int[][] dp = new int[n + 1][n + 1];
        parent = new int[n + 1];
        rank = new int[n + 1];

        // Initialize the dp array
        for (int i = 1; i <= n; i++) {
            dp[i][1] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= i; j++) {
                dp[i][j] = (int) (((long) dp[i - 1][j] * j + dp[i - 1][j - 1]) % MOD);
            }
        }

        // Initialize the Union-Find structure
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
            result.append(sumDp(dp, n)).append("\n");
        }
        System.out.print(result);
    }

    static int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            if (rank[x] < rank[y]) {
                parent[x] = y;
            } else if (rank[x] > rank[y]) {
                parent[y] = x;
            } else {
                parent[y] = x;
                rank[x]++;
            }
            n--;
        }
    }

    static int sumDp(int[][] dp, int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = (sum + dp[n][i]) % MOD;
        }
        return sum;
    }
}
