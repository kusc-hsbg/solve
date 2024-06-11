import java.util.Scanner;

public class _2869 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int V = scanner.nextInt();
        scanner.close();
        
        int days = (int)Math.ceil((double)(V - B) / (A - B));
        System.out.println(days);
    }
}
