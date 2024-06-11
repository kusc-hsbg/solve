import java.util.Scanner;

public class _2775 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        for (int t = 0; t < T; t++) {
            int k = scanner.nextInt();
            int n = scanner.nextInt();
            
            System.out.println(findNumberOfPeople(k, n));
        }
        
        scanner.close();
    }
    
    private static int findNumberOfPeople(int k, int n) {
        int[][] apartment = new int[k + 1][n + 1];
        
        for (int i = 1; i <= n; i++) {
            apartment[0][i] = i;
        }
        
        for (int floor = 1; floor <= k; floor++) {
            for (int room = 1; room <= n; room++) {
                for (int i = 1; i <= room; i++) {
                    apartment[floor][room] += apartment[floor - 1][i];
                }
            }
        }
        
        return apartment[k][n];
    }
}
