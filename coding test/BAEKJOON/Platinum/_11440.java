import java.io.*;
public class _11440 {
    static final long MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(reader.readLine().trim());
        if (n == 0) {
            System.out.println(0);
            return;
        }
        long[] fib = fibonacci(n);
        long fn = fib[0];
        long fn1 = fib[1];
        long result = (fn * fn1) % MOD;
        System.out.println(result);
    }
    private static long[] fibonacci(long n) {
        long[] result = {1, 0};
        long[] fibMatrix = {1, 1, 1, 0};
        while (n > 0) {
            if (n % 2 == 1) {
                result = matrixMultiply(fibMatrix, result);
            }
            fibMatrix = matrixSquare(fibMatrix);
            n /= 2;
        }
        return result;
    }
    private static long[] matrixMultiply(long[] matrix, long[] vector) {
        long a = matrix[0], b = matrix[1], c = matrix[2], d = matrix[3];
        long x = vector[0], y = vector[1];
        return new long[]{
            (a * x + b * y) % MOD,
            (c * x + d * y) % MOD
        };
    }
    private static long[] matrixSquare(long[] matrix) {
        long a = matrix[0], b = matrix[1], c = matrix[2], d = matrix[3];
        return new long[]{
            (a * a + b * c) % MOD, (a * b + b * d) % MOD,
            (c * a + d * c) % MOD, (c * b + d * d) % MOD
        };
    }
}