import java.io.*;
import java.util.*;

public class _1753 {
    static class Node implements Comparable<Node> {
        int node;
        int cost;

        Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        List<List<Node>> graph = new ArrayList<>(V + 1);
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, w));
        }

        int[] distances = dijkstra(K, V, graph);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= V; i++) {
            if (distances[i] == INF) {
                bw.write("INF\n");
            } else {
                bw.write(distances[i] + "\n");
            }
        }
        bw.flush();
        bw.close();
    }

    private static int[] dijkstra(int start, int vertices, List<List<Node>> graph) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] distances = new int[vertices + 1];
        Arrays.fill(distances, INF);
        distances[start] = 0;

        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentNode = current.node;

            if (current.cost > distances[currentNode]) {
                continue;
            }

            for (Node neighbor : graph.get(currentNode)) {
                int newDist = distances[currentNode] + neighbor.cost;
                if (newDist < distances[neighbor.node]) {
                    distances[neighbor.node] = newDist;
                    pq.offer(new Node(neighbor.node, newDist));
                }
            }
        }

        return distances;
    }
}
