import java.util.*;
import java.io.*;

public class _1761 {
    static int node_num;
    static final int TREE_HEIGHT = 20;
    static int[] depth;
    static int[][] parent;
    static int[][] dist;
    static List<List<int[]>> adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        node_num = Integer.parseInt(br.readLine());

        depth = new int[node_num + 1];
        parent = new int[node_num + 1][TREE_HEIGHT];
        dist = new int[node_num + 1][TREE_HEIGHT];
        adj = new ArrayList<>(node_num + 1);
        
        for (int i = 0; i <= node_num; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < node_num - 1; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);
            adj.get(a).add(new int[]{b, cost});
            adj.get(b).add(new int[]{a, cost});
        }

        FindParent(0, 1, 0, 0);

        for (int k = 1; k < TREE_HEIGHT; k++) {
            for (int idx = 2; idx <= node_num; idx++) {
                if (parent[idx][k - 1] != 0) {
                    parent[idx][k] = parent[parent[idx][k - 1]][k - 1];
                    dist[idx][k] = dist[idx][k - 1] + dist[parent[idx][k - 1]][k - 1];
                }
            }
        }

        int pair_num = Integer.parseInt(br.readLine());
        while (pair_num-- > 0) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            out.append(DistNodePair(a, b)).append("\n");
        }

        System.out.print(out);
    }

    static void FindParent(int par, int now, int dep, int cost) {
        depth[now] = dep;
        parent[now][0] = par;
        dist[now][0] = cost;

        for (int[] neighbor : adj.get(now)) {
            if (neighbor[0] != par) {
                FindParent(now, neighbor[0], dep + 1, neighbor[1]);
            }
        }
    }

    static int DistNodePair(int a, int b) {
        int sum = 0;
        if (depth[a] != depth[b]) {
            if (depth[a] < depth[b]) {
                int temp = a;
                a = b;
                b = temp;
            }

            int dif = depth[a] - depth[b];
            for (int i = 0; dif > 0; i++) {
                if (dif % 2 == 1) {
                    sum += dist[a][i];
                    a = parent[a][i];
                }
                dif >>= 1;
            }
        }

        if (a != b) {
            for (int k = TREE_HEIGHT - 1; k >= 0; k--) {
                if (parent[a][k] != 0 && parent[a][k] != parent[b][k]) {
                    sum += dist[a][k] + dist[b][k];
                    a = parent[a][k];
                    b = parent[b][k];
                }
            }
            sum += dist[a][0] + dist[b][0];
        }

        return sum;
    }
}
