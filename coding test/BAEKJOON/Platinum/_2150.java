import java.io.*;
import java.util.*;

public class _2150 {
    static boolean[] alreadyInGroup = new boolean[10001];
    static int[] orderOfFound = new int[10001];
    static int[] highestReachable = new int[10001];
    static int[] numberOfGroup = new int[10001];

    static int tempOrder = 1;
    static int numberOfSCCs = 0;

    static List<List<Integer>> graph = new ArrayList<>(10001);
    static Stack<Integer> s = new Stack<>();

    static List<PriorityQueue<Integer>> SCCs = new ArrayList<>(10001);

    static {
        for (int i = 0; i < 10001; i++) {
            graph.add(new ArrayList<>());
            SCCs.add(new PriorityQueue<>());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(A).add(B);
        }

        for (int i = 1; i <= V; i++) {
            if (orderOfFound[i] == 0) {
                tarjan(i);
            }
        }

        System.out.println(numberOfSCCs);

        PriorityQueue<PriorityQueue<Integer>> orderedSCCs = new PriorityQueue<>(numberOfSCCs, Comparator.comparingInt(PriorityQueue::peek));

        for (int i = 0; i < numberOfSCCs; i++) {
            orderedSCCs.add(SCCs.get(i));
        }

        while (!orderedSCCs.isEmpty()) {
            PriorityQueue<Integer> currentSCC = orderedSCCs.poll();
            while (!currentSCC.isEmpty()) {
                System.out.print(currentSCC.poll() + " ");
            }
            System.out.println(-1);
        }
    }

    public static void tarjan(int nodeToCheck) {
        orderOfFound[nodeToCheck] = highestReachable[nodeToCheck] = tempOrder++;
        s.push(nodeToCheck);

        for (int i : graph.get(nodeToCheck)) {
            if (orderOfFound[i] == 0) {
                tarjan(i);
                highestReachable[nodeToCheck] = Math.min(highestReachable[nodeToCheck], highestReachable[i]);
            } else if (!alreadyInGroup[i]) {
                highestReachable[nodeToCheck] = Math.min(highestReachable[nodeToCheck], orderOfFound[i]);
            }
        }

        if (highestReachable[nodeToCheck] == orderOfFound[nodeToCheck]) {
            while (true) {
                int currentNode = s.pop();
                alreadyInGroup[currentNode] = true;
                SCCs.get(numberOfSCCs).add(currentNode);
                numberOfGroup[currentNode] = numberOfSCCs;
                if (currentNode == nodeToCheck) break;
            }
            numberOfSCCs++;
        }
    }
}
