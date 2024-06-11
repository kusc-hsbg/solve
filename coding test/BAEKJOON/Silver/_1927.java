import java.util.PriorityQueue;
import java.util.Scanner;

public class _1927 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int i = 0; i < N; i++) {
            int x = scanner.nextInt();
            if (x > 0) {
                minHeap.add(x);
            } else {
                if (minHeap.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(minHeap.poll());
                }
            }
        }
        
        scanner.close();
    }
}
