import java.io.*;
public class _11778 {
    static final long MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = reader.readLine().split(" ");
        long n = Long.parseLong(inputs[0]);
        long m = Long.parseLong(inputs[1]);
        long gcd = gcd(n, m);
        long result = fibonacciMod(gcd, MOD);
        System.out.println(result);
    }
    private static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    private static long fibonacciMod(long n, long mod) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        long[][] result = {{1, 0}, {0, 1}};
        long[][] fibonacciMatrix = {{1, 1}, {1, 0}};
        while (n > 0) {
            if (n % 2 == 1) result = matrixMultiply(result, fibonacciMatrix, mod);
            fibonacciMatrix = matrixMultiply(fibonacciMatrix, fibonacciMatrix, mod);
            n /= 2;
        }
        return result[0][1];
    }
    private static long[][] matrixMultiply(long[][] a, long[][] b, long mod) {
        long[][] result = new long[2][2];
        result[0][0] = (a[0][0] * b[0][0] + a[0][1] * b[1][0]) % mod;
        result[0][1] = (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % mod;
        result[1][0] = (a[1][0] * b[0][0] + a[1][1] * b[1][0]) % mod;
        result[1][1] = (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % mod;
        return result;
    }
}