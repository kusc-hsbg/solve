import java.io.*;
import java.util.*;

public class _1238 {
    static List<List<Edge>> graph, reverseGraph;
    static int N, X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>(N + 1);
        reverseGraph = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Edge(end, weight));
            reverseGraph.get(end).add(new Edge(start, weight));
        }

        int[] distToX = dijkstra(graph, X);
        int[] distFromX = dijkstra(reverseGraph, X);

        int maxTravelTime = 0;
        for (int i = 1; i <= N; i++) {
            maxTravelTime = Math.max(maxTravelTime, distToX[i] + distFromX[i]);
        }
        System.out.println(maxTravelTime);
    }

    private static int[] dijkstra(List<List<Edge>> adjList, int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int currentNode = current.node;

            if (visited[currentNode]) continue;
            visited[currentNode] = true;

            for (Edge edge : adjList.get(currentNode)) {
                if (!visited[edge.node] && dist[edge.node] > dist[currentNode] + edge.weight) {
                    dist[edge.node] = dist[currentNode] + edge.weight;
                    pq.offer(new Edge(edge.node, dist[edge.node]));
                }
            }
        }
        return dist;
    }

    static class Edge implements Comparable<Edge> {
        int node, weight;

        Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }
}
