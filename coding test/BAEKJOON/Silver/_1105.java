import java.util.Scanner;

public class _1105 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String L = scanner.next();
        String R = scanner.next();
        scanner.close();

        int minEights = countEightsInRange(L, R);
        System.out.println(minEights);
    }

    private static int countEightsInRange(String L, String R) {
        if (L.length() != R.length()) {
            return 0;
        }

        int count = 0;
        boolean mismatchFound = false;

        for (int i = 0; i < L.length(); i++) {
            char lChar = L.charAt(i);
            char rChar = R.charAt(i);

            if (mismatchFound) {
                break;
            }

            if (lChar == rChar) {
                if (lChar == '8') {
                    count++;
                }
            } else {
                mismatchFound = true;
            }
        }
        return count;
    }
}