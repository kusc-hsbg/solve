import java.util.Scanner;

public class _31534 {
    static final double PI = Math.acos(-1);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%.7f\n", solve(scanner));
        scanner.close();
    }

    public static double solve(Scanner scanner) {
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double h = scanner.nextDouble();

        if (a == b) {
            return -1;
        }

        if (a > b) {
            double temp = a;
            a = b;
            b = temp;
        }

        double lowH = a * h / (b - a);

        double bigSize = Math.pow(lowH + h, 2) + Math.pow(b, 2);
        double smallSize = a != 0 ? Math.pow(lowH, 2) + Math.pow(a, 2) : 0;

        return (bigSize - smallSize) * PI;
    }
}
