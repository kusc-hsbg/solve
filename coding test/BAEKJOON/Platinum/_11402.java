import java.math.BigInteger;
import java.util.Scanner;

public class _11402 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) { 
            long N = sc.nextLong();
            long K = sc.nextLong();
            int M = sc.nextInt();

            System.out.println(binomialMod(N, K, M));
        }
    }

    private static long binomialMod(long N, long K, int M) {
        long result = 1;
        while (N > 0 || K > 0) {
            long nMod = N % M;
            long kMod = K % M;
            if (kMod > nMod) {
                return 0;
            }
            result = (result * binomial(nMod, kMod, M)) % M;
            N /= M;
            K /= M;
        }
        return result;
    }

    private static long binomial(long n, long k, int p) {
        if (k > n) {
            return 0;
        }
        long numerator = 1;
        long denominator = 1;
        for (long i = 0; i < k; i++) {
            numerator = (numerator * (n - i)) % p;
            denominator = (denominator * (i + 1)) % p;
        }
        return (numerator * modInverse(denominator, p)) % p;
    }

    private static long modInverse(long a, int p) {
        return BigInteger.valueOf(a).modInverse(BigInteger.valueOf(p)).longValue();
    }
}