import java.util.*;

public class _1260 {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); 
        int M = sc.nextInt(); 
        int V = sc.nextInt(); 

        // graph = (ArrayList<Integer>[]) new ArrayList[N + 1]; (+)
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        visited = new boolean[N + 1];
        dfs(V);
        sb.append("\n");

        visited = new boolean[N + 1];
        bfs(V);

        sc.close();
        System.out.println(sb.toString());
    }

    static void dfs(int v) {
        visited[v] = true;
        sb.append(v).append(" ");
        for (int next : graph[v]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int v = queue.poll();
            sb.append(v).append(" ");

            for (int next : graph[v]) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}
