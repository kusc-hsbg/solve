import java.util.Scanner;

public class _6064 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int M = scanner.nextInt();
            int N = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            
            int result = findYear(M, N, x, y);
            System.out.println(result);
        }
        
        scanner.close();
    }
    
    public static int findYear(int M, int N, int x, int y) {
        int maxYear = M * N;
        
        for (int i = x; i <= maxYear; i += M) {
            if ((i - 1) % N + 1 == y) {
                return i;
            }
        }
        
        return -1;
    }
}