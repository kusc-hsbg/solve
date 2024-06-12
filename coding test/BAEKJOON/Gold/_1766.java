import java.util.*;

public class _1766 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[N + 1];
        
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < M; i++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            graph.get(A).add(B);
            inDegree[B]++;
        }

        scanner.close();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                pq.add(i);
            }
        }
        
        List<Integer> result = new ArrayList<>();
        
        while (!pq.isEmpty()) {
            int current = pq.poll();
            result.add(current);
            
            for (int neighbor : graph.get(current)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    pq.add(neighbor);
                }
            }
        }
        
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
