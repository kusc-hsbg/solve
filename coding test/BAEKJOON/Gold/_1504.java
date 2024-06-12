import java.util.*;

public class _1504 {
    static class Edge implements Comparable<Edge> {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int E = scanner.nextInt();
        List<List<Edge>> graph = new ArrayList<>(N);

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int u = scanner.nextInt() - 1;
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt();
            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }

        int v1 = scanner.nextInt() - 1;
        int v2 = scanner.nextInt() - 1;

        scanner.close();

        int[] distFromStart = dijkstra(N, 0, graph);
        int[] distFromV1 = dijkstra(N, v1, graph);
        int[] distFromV2 = dijkstra(N, v2, graph);

        long path1 = (long) distFromStart[v1] + distFromV1[v2] + distFromV2[N - 1];
        long path2 = (long) distFromStart[v2] + distFromV2[v1] + distFromV1[N - 1];

        long result = Math.min(path1, path2);

        System.out.println(result >= INF ? -1 : result);
    }

    static int[] dijkstra(int N, int start, List<List<Edge>> graph) {
        int[] dist = new int[N];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int u = current.to;

            if (current.weight > dist[u]) continue;

            for (Edge edge : graph.get(u)) {
                int v = edge.to;
                int weight = edge.weight;

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Edge(v, dist[v]));
                }
            }
        }

        return dist;
    }
}
