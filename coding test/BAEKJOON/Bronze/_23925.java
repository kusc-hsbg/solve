import java.util.Scanner;
public class _23925 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        for (int t = 1; t <= T; t++) {
            long N = scanner.nextLong();
            long K = scanner.nextLong();
            long S = scanner.nextLong();
            
            long timeRestart = K + N;
            long timeBack = (K - 1) + (K - S) + (N - S + 1);
            long result = Math.min(timeRestart, timeBack);
            System.out.println("Case #" + t + ": " + result);
        }
        scanner.close();
    }
}