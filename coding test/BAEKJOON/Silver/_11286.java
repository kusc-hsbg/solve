import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Comparator;

public class _11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> absHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int abs1 = Math.abs(o1);
                int abs2 = Math.abs(o2);
                if (abs1 == abs2) {
                    return o1 - o2; 
                }
                return abs1 - abs2;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x != 0) {
                absHeap.add(x);
            } else {
                if (absHeap.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(absHeap.poll()).append("\n");
                }
            }
        }
        System.out.print(sb.toString());
    }
}