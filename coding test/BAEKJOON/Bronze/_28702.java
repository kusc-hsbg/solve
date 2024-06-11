import java.util.Scanner;

public class _28702 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();
        String c = scanner.next();
        scanner.close();

        if (Character.isDigit(c.charAt(0))) {
            int x = Integer.parseInt(c) + 1;
            printFizzBuzz(x);
        } else if (Character.isDigit(b.charAt(0))) {
            int x = Integer.parseInt(b) + 2;
            printFizzBuzz(x);
        } else if (Character.isDigit(a.charAt(0))) {
            int x = Integer.parseInt(a) + 3;
            printFizzBuzz(x);
        }
    }

    private static void printFizzBuzz(int x) {
        if (x % 3 == 0) {
            if (x % 5 == 0) {
                System.out.println("FizzBuzz");
            } else {
                System.out.println("Fizz");
            }
        } else if (x % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(x);
        }
    }
}
