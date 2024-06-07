import java.util.*;

public class _1031 {
    static int N, M, K;
    static int[][] capacity, flow;
    static List<List<Integer>> adj;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        K = N + M + 2;

        int[] row = new int[N];
        int[] column = new int[M];
        for (int i = 0; i < N; i++) {
            row[i] = scanner.nextInt();
        }
        for (int i = 0; i < M; i++) {
            column[i] = scanner.nextInt();
        }

        capacity = new int[K][K];
        flow = new int[K][K];
        adj = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            capacity[0][i] = row[i - 1];
            adj.get(0).add(i);
            adj.get(i).add(0);
            for (int j = 1; j <= M; j++) {
                capacity[i][j + N] = 1;
                adj.get(i).add(j + N);
                adj.get(j + N).add(i);
            }
        }
        for (int j = 1; j <= M; j++) {
            capacity[j + N][K - 1] = column[j - 1];
            adj.get(j + N).add(K - 1);
            adj.get(K - 1).add(j + N);
        }

        while (true) {
            int[] parent = bfs();
            if (parent == null) break;
            int now = K - 1;
            while (now != 0) {
                int prev = parent[now];
                flow[prev][now]++;
                flow[now][prev]--;
                now = prev;
            }
        }

        if (Arrays.stream(flow[0]).sum() == Arrays.stream(column).sum() && Arrays.stream(flow[0]).sum() == Arrays.stream(row).sum()) {
            for (int i = 1; i <= N; i++) {
                for (int j = N + 1; j <= N + M; j++) {
                    if (flow[i][j] > 0) {
                        int[] parent = update(i, j);
                        if (parent != null) {
                            flow[i][j]--;
                            while (j != i) {
                                int prev = parent[j];
                                flow[prev][j]++;
                                flow[j][prev]--;
                                j = prev;
                            }
                        }
                    }
                }
            }
            for (int i = 1; i <= N; i++) {
                for (int j = N + 1; j <= N + M; j++) {
                    System.out.print(flow[i][j]);
                }
                System.out.println();
            }
        } else {
            System.out.println(-1);
        }

        scanner.close();
    }

    static int[] bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int[] parent = new int[K];
        Arrays.fill(parent, -1);
        parent[0] = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int next : adj.get(curr)) {
                if (parent[next] == -1 && capacity[curr][next] - flow[curr][next] > 0) {
                    parent[next] = curr;
                    queue.add(next);
                    if (next == K - 1) {
                        return parent;
                    }
                }
            }
        }
        return null;
    }

    static int[] update(int i, int j) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        int[] parent = new int[K];
        Arrays.fill(parent, -1);
        parent[i] = i;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int next : adj.get(curr)) {
                if ((next < i || (curr == i && next <= j)) || parent[next] != -1) continue;
                if (capacity[curr][next] - flow[curr][next] > 0) {
                    parent[next] = curr;
                    queue.add(next);
                    if (next == j) {
                        return parent;
                    }
                }
            }
        }
        return null;
    }
}