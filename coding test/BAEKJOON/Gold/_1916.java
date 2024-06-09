import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1916 {
    static class Node implements Comparable<Node> {
        int city, cost;
        Node(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(n, graph, start, end));
    }

    private static int dijkstra(int n, List<List<Node>> graph, int start, int end) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentCity = current.city;
            int currentCost = current.cost;

            if (currentCost > dist[currentCity]) continue;

            for (Node next : graph.get(currentCity)) {
                int nextCity = next.city;
                int nextCost = currentCost + next.cost;

                if (nextCost < dist[nextCity]) {
                    dist[nextCity] = nextCost;
                    pq.add(new Node(nextCity, nextCost));
                }
            }
        }

        return dist[end];
    }
}
