import java.util.Scanner;

public class _18247 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int T = scanner.nextInt();
        
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            
            if (N < 12 || 4 > M) {
                System.out.println(-1);
            } else {
                int L = 12;
                int seatNumber = (L - 1) * M + 4;
                System.out.println(seatNumber);
            }
        }
        
        scanner.close();
    }
}