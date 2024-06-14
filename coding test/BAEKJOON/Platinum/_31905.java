import java.util.Scanner;

public class _31905 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int n = sc.nextInt();
            int m = sc.nextInt();

            double ans = 0;
            int totalElements = n * m;

            for (int i = 0; i < totalElements; i++) {
                double x = sc.nextDouble();
                ans += x / totalElements;
            }

            System.out.printf("%.6f\n", ans);
        } finally {
            sc.close();
        }
    }
}
