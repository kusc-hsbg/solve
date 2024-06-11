import java.util.*;

public class _1167 {
    static class Node {
        int vertex, weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    static List<List<Node>> graph;
    static boolean[] visited;
    static int maxDistance;
    static int farthestNode;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int V = scanner.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            int u = scanner.nextInt();
            while (true) {
                int v = scanner.nextInt();
                if (v == -1) break;
                int weight = scanner.nextInt();
                graph.get(u).add(new Node(v, weight));
            }
        }
        scanner.close();

        visited = new boolean[V + 1];
        maxDistance = 0;
        farthestNode = 0;
        
        dfs(1, 0);

        Arrays.fill(visited, false);
        maxDistance = 0;
        dfs(farthestNode, 0);

        System.out.println(maxDistance);
    }

    static void dfs(int node, int distance) {
        visited[node] = true;

        if (distance > maxDistance) {
            maxDistance = distance;
            farthestNode = node;
        }

        for (Node neighbor : graph.get(node)) {
            if (!visited[neighbor.vertex]) {
                dfs(neighbor.vertex, distance + neighbor.weight);
            }
        }
    }
}
