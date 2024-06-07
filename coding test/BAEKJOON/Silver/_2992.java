import java.util.Arrays;
import java.util.Scanner;

public class _2992 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String X = scanner.nextLine();
            
            char[] digits = X.toCharArray();
            Arrays.sort(digits);
            
            for (int i = Integer.parseInt(X) + 1; i <= 999999; i++) {
                char[] temp = String.valueOf(i).toCharArray();
                Arrays.sort(temp);
                if (Arrays.equals(digits, temp)) {
                    System.out.println(i);
                    return;
                }
            }
            
            System.out.println("0");
        }
    }
}
