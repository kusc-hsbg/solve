import java.util.*;

public class _1240 {
    static int N, M;
    static List<Node>[] tree;
    static int[][] parent;
    static int[] depth;
    static int[][] distance;
    static int LOG;

    static class Node {
        int to, weight;
        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        @SuppressWarnings("unchecked")
        List<Node>[] tempTree = new ArrayList[N + 1];
        tree = tempTree;

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            tree[u].add(new Node(v, w));
            tree[v].add(new Node(u, w));
        }

        LOG = (int) Math.ceil(Math.log(N) / Math.log(2));
        parent = new int[N + 1][LOG];
        depth = new int[N + 1];
        distance = new int[N + 1][LOG];

        dfs(1, 0, 0);

        for (int j = 1; j < LOG; j++) {
            for (int i = 1; i <= N; i++) {
                parent[i][j] = parent[parent[i][j - 1]][j - 1];
                distance[i][j] = distance[i][j - 1] + distance[parent[i][j - 1]][j - 1];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            sb.append(getDistance(a, b)).append("\n");
        }

        scanner.close();
        System.out.print(sb.toString());
    }

    static void dfs(int node, int dep, int dist) {
        depth[node] = dep;
        for (Node next : tree[node]) {
            if (depth[next.to] == 0 && next.to != 1) {
                parent[next.to][0] = node;
                distance[next.to][0] = next.weight;
                dfs(next.to, dep + 1, dist + next.weight);
            }
        }
    }

    static int getDistance(int a, int b) {
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        int dist = 0;

        for (int i = LOG - 1; i >= 0; i--) {
            if (depth[a] - depth[b] >= (1 << i)) {
                dist += distance[a][i];
                a = parent[a][i];
            }
        }

        if (a == b) {
            return dist;
        }

        for (int i = LOG - 1; i >= 0; i--) {
            if (parent[a][i] != parent[b][i]) {
                dist += distance[a][i] + distance[b][i];
                a = parent[a][i];
                b = parent[b][i];
            }
        }

        return dist + distance[a][0] + distance[b][0];
    }
}
