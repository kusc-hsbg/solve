/*import java.util.*;

public class _1210 {
    static final int INF = (int) 1e9;
    static int[][] c = new int[444][444];
    static int[][] f = new int[444][444];
    static List<Integer>[] g = new ArrayList[444];
    static int s, t;
    static int[] lv = new int[444];
    static int[] work = new int[444];
    static int[] chk = new int[444];
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        s = sc.nextInt();
        t = sc.nextInt() + n;

        for (int i = 0; i < 444; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            int x = sc.nextInt();
            addEdge(i, i + n, x);
        }

        for (int i = 1; i <= m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            addEdge(a + n, b);
            addEdge(b + n, a);
        }

        solve();
    }

    static void addEdge(int s, int e, int x) {
        g[s].add(e);
        c[s][e] = x;
        g[e].add(s);
    }

    static void addEdge(int s, int e) {
        addEdge(s, e, INF);
    }

    static boolean bfs() {
        Arrays.fill(lv, -1);
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        lv[s] = 0;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int nxt : g[now]) {
                if (lv[nxt] == -1 && c[now][nxt] - f[now][nxt] > 0) {
                    lv[nxt] = lv[now] + 1;
                    q.add(nxt);
                }
            }
        }
        return lv[t] != -1;
    }

    static int dfs(int now, int tot) {
        if (now == t) return tot;
        for (int i = work[now]; i < g[now].size(); i++) {
            int nxt = g[now].get(i);
            if (lv[nxt] == lv[now] + 1 && c[now][nxt] - f[now][nxt] > 0) {
                int fl = dfs(nxt, Math.min(tot, c[now][nxt] - f[now][nxt]));
                if (fl > 0) {
                    f[now][nxt] += fl;
                    f[nxt][now] -= fl;
                    return fl;
                }
            }
        }
        return 0;
    }

    static int dinic() {
        int ret = 0;
        while (bfs()) {
            Arrays.fill(work, 0);
            while (true) {
                int fl = dfs(s, INF + 10);
                if (fl <= 0) break;
                ret += fl;
            }
        }
        return ret;
    }

    static void solve() {
        dinic();
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        chk[s] = 1;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int nxt : g[now]) {
                if (chk[nxt] != 0) continue;
                if (c[now][nxt] - f[now][nxt] > 0) {
                    q.add(nxt);
                    chk[nxt] = 1;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (chk[i] != 0 && chk[i + n] == 0) {
                System.out.print(i + " ");
            }
        }
    }
}
*/