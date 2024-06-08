import java.util.Scanner;

public class _13777 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int rabbitPosition = scanner.nextInt();
            if (rabbitPosition == 0) {
                break;
            }

            findRabbit(rabbitPosition);
        }

        scanner.close();
    }

    private static void findRabbit(int rabbitPosition) {
        int low = 1;
        int high = 50;

        StringBuilder result = new StringBuilder();

        while (low <= high) {
            int mid = (low + high) / 2;
            result.append(mid).append(" ");
            if (mid == rabbitPosition) {
                break;
            } else if (mid < rabbitPosition) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(result.toString().trim());
    }
}
