import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _1038 {
    private static int N;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        
        scanner.close();

        if (0 <= N && N <= 10) {
            System.out.println(N);
            return;
        }

        Queue<Long> queue = new LinkedList<>();
        for (int i = 1; i <= 9; i++) {
            queue.add((long) i);
        }

        int index = 10;
        long currentNumber = 0;
        while (index <= N && !queue.isEmpty()) {
            currentNumber = queue.poll();
            int lastDigit = (int) (currentNumber % 10);
            for (int i = 0; i < lastDigit; i++) {
                queue.add(currentNumber * 10 + i);
                if (index == N) {
                    System.out.println(currentNumber * 10 + i);
                    return;
                }
                index++;
            }
        }

        System.out.println(-1);
    }
}