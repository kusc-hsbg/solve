import java.util.Scanner;

public class _10350 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        
        scanner.close();
        
        long[] s = new long[n * 2 + 1];
        for (int i = 0; i < n * 2; i++) {
            s[i + 1] = s[i] + a[i % n];
        }

        long result = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int i2 = 1; i2 <= n; i2++) {
                if (s[i2 + i] < s[i2 - 1]) {
                    result += Math.ceil(Math.abs((double)(s[i2 + i] - s[i2 - 1]) / s[n]));
                }
            }
        }
        System.out.println(result);
    }
}
