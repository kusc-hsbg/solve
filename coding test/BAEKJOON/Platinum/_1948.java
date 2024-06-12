import java.io.*;
import java.util.*;

public class _1948 {
    static class Node {
        int targetNode;
        int value;

        public Node(int targetNode, int value) {
            this.targetNode = targetNode;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());   
        int M = Integer.parseInt(br.readLine()); 
        
        List<List<Node>> graph = new ArrayList<>();
        List<List<Node>> reverseGraph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }
        
        int[] indegree = new int[N + 1];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            graph.get(S).add(new Node(E, V));
            reverseGraph.get(E).add(new Node(S, V)); 
            indegree[E]++;  
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startCity);
        int[] longestPath = new int[N + 1];
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (Node neighbor : graph.get(current)) {
                indegree[neighbor.targetNode]--;
                longestPath[neighbor.targetNode] = Math.max(longestPath[neighbor.targetNode], longestPath[current] + neighbor.value);
                if (indegree[neighbor.targetNode] == 0) {
                    queue.offer(neighbor.targetNode);
                }
            }
        }

        int resultCount = 0;
        boolean[] visited = new boolean[N + 1];
        queue = new LinkedList<>();
        queue.offer(endCity);
        visited[endCity] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (Node neighbor : reverseGraph.get(current)) {
                if (longestPath[neighbor.targetNode] + neighbor.value == longestPath[current]) {
                    resultCount++;
                    if (!visited[neighbor.targetNode]) {
                        visited[neighbor.targetNode] = true;
                        queue.offer(neighbor.targetNode);
                    }
                }
            }
        }

        System.out.println(longestPath[endCity]);
        System.out.println(resultCount);
    }
}
