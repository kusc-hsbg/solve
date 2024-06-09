import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _1068 {
    static List<Integer>[] tree;
    static boolean[] visited;
    static int deleteNode;
    static int leafCount;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        tree = new ArrayList[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        int root = -1;
        for (int i = 0; i < n; i++) {
            int parent = scanner.nextInt();
            if (parent == -1) {
                root = i;
            } else {
                tree[parent].add(i);
            }
        }

        deleteNode = scanner.nextInt();
        scanner.close();

        if (deleteNode == root) {
            System.out.println(0);
            return;
        }

        dfs(root);

        System.out.println(leafCount);
    }

    public static void dfs(int node) {
        if (node == deleteNode) {
            return;
        }

        visited[node] = true;
        boolean isLeaf = true;

        for (int child : tree[node]) {
            if (!visited[child] && child != deleteNode) {
                isLeaf = false;
                dfs(child);
            }
        }

        if (isLeaf) {
            leafCount++;
        }
    }
}
