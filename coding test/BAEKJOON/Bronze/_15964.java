import java.util.Scanner;

public class _15964 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long A = sc.nextInt();
        long B = sc.nextInt();
        long result = (A + B) * (A - B);

        System.out.println(result);
        sc.close();
    }
}