import java.util.*;

public class _1334 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.next();
        scanner.close();
        System.out.println(findNextPalindrome(n));
    }

    public static String findNextPalindrome(String n) {
        int len = n.length();
        char[] result = n.toCharArray();
        boolean incremented = false;

        for (int i = 0; i < len / 2; i++) {
            result[len - 1 - i] = result[i];
        }

        String palindrome = new String(result);
        if (palindrome.compareTo(n) > 0) {
            return palindrome;
        }

        for (int i = (len - 1) / 2; i >= 0; i--) {
            if (result[i] != '9') {
                result[i]++;
                result[len - 1 - i] = result[i];
                incremented = true;
                break;
            } else {
                result[i] = '0';
                result[len - 1 - i] = '0';
            }
        }

        if (!incremented) {
            char[] newResult = new char[len + 1];
            Arrays.fill(newResult, '0');
            newResult[0] = '1';
            newResult[len] = '1';
            return new String(newResult);
        }

        for (int i = 0; i < len / 2; i++) {
            result[len - 1 - i] = result[i];
        }

        return new String(result);
    }
}
