import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _1013 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();

        String regex = "(100+1+|01)+";
        Pattern pattern = Pattern.compile(regex);

        for (int t = 0; t < T; t++) {
            String signal = scanner.nextLine();
            Matcher matcher = pattern.matcher(signal);

            if (matcher.matches()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        scanner.close();
    }
}
