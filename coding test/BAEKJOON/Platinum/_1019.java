import java.util.Scanner;

public class _1019 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long N = scanner.nextLong();
        scanner.close();

        long[] counts = new long[10];
        long factor = 1;

        while (N >= factor) {
            long lowerNumbers = N - (N / factor) * factor;
            long currentDigit = (N / factor) % 10;
            long higherNumbers = N / (factor * 10);

            for (int i = 0; i < 10; i++) {
                counts[i] += higherNumbers * factor;
            }
            for (int i = 0; i < currentDigit; i++) {
                counts[i] += factor;
            }
            counts[(int) currentDigit] += lowerNumbers + 1;
            counts[0] -= factor;
            factor *= 10;
        }

        for (long count : counts) {
            System.out.print(count + " ");
        }
    }
}
