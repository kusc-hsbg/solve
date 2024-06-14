import java.util.Scanner;
public class _18185 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] c = new int[n + 2];
        for (int i = 0; i < n; i++) {
            c[i] = scanner.nextInt();
        }
        int price = 0;

        for (int i = 0; i < n; i++) {
            if (c[i + 1] > c[i + 2]) {
                int minimum = Math.min(c[i], c[i + 1] - c[i + 2]);
                c[i] -= minimum;
                c[i + 1] -= minimum;
                price += minimum * 5;

                minimum = Math.min(c[i], Math.min(c[i + 1], c[i + 2]));
                c[i] -= minimum;
                c[i + 1] -= minimum;
                c[i + 2] -= minimum;
                price += minimum * 7;
            } else {
                int minimum = Math.min(c[i], Math.min(c[i + 1], c[i + 2]));
                c[i] -= minimum;
                c[i + 1] -= minimum;
                c[i + 2] -= minimum;
                price += minimum * 7;

                minimum = Math.min(c[i], c[i + 1]);
                c[i] -= minimum;
                c[i + 1] -= minimum;
                price += minimum * 5;
            }
            price += c[i] * 3;
        }
        System.out.println(price);
        scanner.close();
    }
}