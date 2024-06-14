/*import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class _3648 {
    static final int MAX = 2002;
    static int n, m, cnt;
    static int[] scc, chk, ans;
    static ArrayList<Integer>[] gph;
    static ArrayList<ArrayList<Integer>> res;
    static Stack<Integer> stk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        while (true) {
            String line = br.readLine();
            if (line == null || line.equals("")) break;
            
            st = new StringTokenizer(line);
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            
            scc = new int[MAX];
            chk = new int[MAX];
            ans = new int[MAX];
            gph = new ArrayList[MAX];
            for (int i = 0; i < MAX; i++) {
                gph[i] = new ArrayList<>();
            }
            res = new ArrayList<>();
            stk = new Stack<>();
            cnt = 0;
            
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                if (u < 0) u = -u + n;
                if (v < 0) v = -v + n;
                if (u == 1 || v == n + 1) v = u;
                if (v == 1 || u == n + 1) u = v;
                gph[f(u)].add(v);
                gph[f(v)].add(u);
            }

            for (int i = 1; i <= 2 * n; i++) {
                if (chk[i] == 0) getSCC(i);
            }

            boolean flag = false;
            for (int i = 1; i <= n; i++) {
                if (ans[i] == ans[i + n]) {
                    flag = true;
                    break;
                }
            }
            System.out.println(flag ? "no" : "yes");
        }
    }

    static int getSCC(int now) {
        chk[now] = ++cnt;
        int ret = chk[now];
        stk.push(now);

        for (int next : gph[now]) {
            if (chk[next] == 0) {
                ret = Math.min(ret, getSCC(next));
            } else if (scc[next] == 0) {
                ret = Math.min(ret, chk[next]);
            }
        }

        if (ret == chk[now]) {
            ArrayList<Integer> curSCC = new ArrayList<>();
            while (true) {
                int top = stk.pop();
                scc[top] = res.size() + 1;
                curSCC.add(top);
                ans[top] = res.size() + 1;
                if (top == now) break;
            }
            res.add(curSCC);
        }

        return ret;
    }

    static int f(int u) {
        return u > n ? u - n : u + n;
    }
}
*/