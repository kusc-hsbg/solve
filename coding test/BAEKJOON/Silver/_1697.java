import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        System.out.println(bfs(N, K));
    }

    public static int bfs(int N, int K) {
        if (N == K) {
            return 0;
        }

        int[] visited = new int[100001];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visited[N] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : new int[]{current - 1, current + 1, current * 2}) {
                if (next == K) {
                    return visited[current];
                }

                if (next >= 0 && next <= 100000 && visited[next] == 0) {
                    queue.add(next);
                    visited[next] = visited[current] + 1;
                }
            }
        }
        return -1;
    }
}
