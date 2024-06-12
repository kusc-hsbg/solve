import java.util.*;

public class _1967 {
    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        List<List<Edge>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n - 1; i++) {
            int parent = scanner.nextInt() - 1;
            int child = scanner.nextInt() - 1;
            int weight = scanner.nextInt();
            tree.get(parent).add(new Edge(child, weight));
            tree.get(child).add(new Edge(parent, weight));
        }

        scanner.close();

        int[] firstBFSResult = bfs(tree, 0);
        int farthestNodeFromRoot = firstBFSResult[0];
        
        int[] secondBFSResult = bfs(tree, farthestNodeFromRoot);
        int diameter = secondBFSResult[1];

        System.out.println(diameter);
    }

    static int[] bfs(List<List<Edge>> tree, int startNode) {
        int n = tree.size();
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        dist[startNode] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);

        int farthestNode = startNode;
        int maxDistance = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (Edge edge : tree.get(current)) {
                if (dist[edge.to] == -1) {
                    dist[edge.to] = dist[current] + edge.weight;
                    queue.add(edge.to);

                    if (dist[edge.to] > maxDistance) {
                        maxDistance = dist[edge.to];
                        farthestNode = edge.to;
                    }
                }
            }
        }

        return new int[]{farthestNode, maxDistance};
    }
}
