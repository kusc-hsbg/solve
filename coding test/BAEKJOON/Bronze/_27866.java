import java.util.Scanner;

public class _27866 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S = scanner.next();
        int i = scanner.nextInt();

        char result = S.charAt(i - 1);
        System.out.println(result);
        scanner.close();
    }
}