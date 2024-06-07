import java.util.Scanner;

public class _1152 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        scanner.close();

        if (input.isEmpty()) {
            System.out.println(0);
            return;
        }
        String[] words = input.split("\\s+");
        System.out.println(words.length);
    }
}
