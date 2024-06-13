import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _15887 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] cards = new int[N];
        for (int i = 0; i < N; i++) {
            cards[i] = scanner.nextInt();
        }
        scanner.close();

        List<int[]> operations = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            while (cards[i] != i + 1) {
                int targetIndex = findIndex(cards, i + 1);
                reverse(cards, i, targetIndex);
                operations.add(new int[]{i + 1, targetIndex + 1});
            }
        }

        System.out.println(operations.size());
        for (int[] operation : operations) {
            System.out.println(operation[0] + " " + operation[1]);
        }
    }

    private static int findIndex(int[] cards, int value) {
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] == value) {
                return i;
            }
        }
        return -1;
    }

    private static void reverse(int[] cards, int start, int end) {
        while (start < end) {
            int temp = cards[start];
            cards[start] = cards[end];
            cards[end] = temp;
            start++;
            end--;
        }
    }
}
