import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _11866 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int K = scanner.nextInt();
        scanner.close(); // Scanner를 닫습니다.

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        StringBuilder result = new StringBuilder();
        result.append("<");

        while (!queue.isEmpty()) {
            for (int i = 0; i < K - 1; i++) {
                int front = queue.poll();
                queue.add(front);
            }
            int removed = queue.poll();
            result.append(removed);
            if (!queue.isEmpty()) {
                result.append(", ");
            }
        }
        
        result.append(">");
        System.out.println(result.toString());
    }
}
