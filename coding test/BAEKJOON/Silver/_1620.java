import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _1620 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine();
        
        Map<String, Integer> nameToNumber = new HashMap<>();
        String[] numberToName = new String[N + 1];
        
        for (int i = 1; i <= N; i++) {
            String name = scanner.nextLine();
            nameToNumber.put(name, i);
            numberToName[i] = name;
        }
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String query = scanner.nextLine();
            if (Character.isDigit(query.charAt(0))) {
                int num = Integer.parseInt(query);
                result.append(numberToName[num]).append("\n");
            } else {
                result.append(nameToNumber.get(query)).append("\n");
            }
        }
        
        scanner.close();
        System.out.print(result);
    }
}
