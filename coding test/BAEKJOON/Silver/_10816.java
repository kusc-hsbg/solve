import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _10816 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        Map<Integer, Integer> cardCountMap = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            int card = scanner.nextInt();
            cardCountMap.put(card, cardCountMap.getOrDefault(card, 0) + 1);
        }
        
        int M = scanner.nextInt();
        int[] results = new int[M];
        
        for (int i = 0; i < M; i++) {
            int query = scanner.nextInt();
            results[i] = cardCountMap.getOrDefault(query, 0);
        }
        
        scanner.close();
        
        StringBuilder output = new StringBuilder();
        for (int result : results) {
            output.append(result).append(" ");
        }
        System.out.println(output.toString().trim());
    }
}
