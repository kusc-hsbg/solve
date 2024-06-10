import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _2164 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        scanner.close();
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
        
        while (queue.size() > 1) {
            queue.poll();
            queue.add(queue.poll());
        }
        
        System.out.println(queue.peek());
    }
}