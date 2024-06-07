import java.util.Scanner;

public class _1011 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int TC = scanner.nextInt();
        
        for (int i = 0; i < TC; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int length = y - x;
            int d = (int) Math.sqrt(length);
            int move_count = (Math.pow(d, 2) == length) ? (2 * d - 1) : (2 * d); // Check if it's a perfect square

            if (length > d * (d + 1)) {
                move_count++; 
            }
            
            System.out.println(move_count);
        }
        
        scanner.close();
    }
}