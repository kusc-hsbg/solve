import java.util.*;

public class _2533 {
    static int N;
    static List<List<Integer>> tree;
    static int[][] dp;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        tree = new ArrayList<>();
        dp = new int[N + 1][2];
        visited = new boolean[N + 1];
        
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }
        
        for (int i = 0; i < N - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            tree.get(u).add(v);
            tree.get(v).add(u);
        }
        
        scanner.close(); 
        
        dfs(1);
        
        int result = Math.min(dp[1][0], dp[1][1]);
        System.out.println(result);
    }

    static void dfs(int node) {
        visited[node] = true;
        dp[node][0] = 0;
        dp[node][1] = 1;
        
        for (int child : tree.get(node)) {
            if (!visited[child]) {
                dfs(child);
                dp[node][0] += dp[child][1];
                dp[node][1] += Math.min(dp[child][0], dp[child][1]);
            }
        }
    }
}
