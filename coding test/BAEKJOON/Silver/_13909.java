import java.util.Scanner;

public class _13909 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long N = scanner.nextLong();
        scanner.close();
        
        long result = (long) Math.sqrt(N);
        System.out.println(result);
    }
}
