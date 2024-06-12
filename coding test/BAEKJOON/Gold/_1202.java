import java.io.*;
import java.util.*;

public class _1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        Jewel[] jewels = new Jewel[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel(weight, value);
        }
        
        int[] bagCapacity = new int[K];
        for (int i = 0; i < K; i++) {
            bagCapacity[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewels, Comparator.comparingInt(j -> j.weight));
        Arrays.sort(bagCapacity);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        long maxTotalValue = 0;
        int jewelIndex = 0;

        for (int capacity : bagCapacity) {
            while (jewelIndex < N && jewels[jewelIndex].weight <= capacity) {
                maxHeap.add(jewels[jewelIndex].value);
                jewelIndex++;
            }

            if (!maxHeap.isEmpty()) {
                maxTotalValue += maxHeap.poll();
            }
        }

        System.out.println(maxTotalValue);
    }

    static class Jewel {
        int weight;
        int value;

        Jewel(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}
