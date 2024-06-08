import java.math.BigInteger;
import java.util.*;

public class _13926 {
    static class MillerRabin {
        
        static BigInteger pow(BigInteger base, BigInteger exp, BigInteger mod) {
            BigInteger result = BigInteger.ONE;
            while (exp.compareTo(BigInteger.ZERO) > 0) {
                if (exp.and(BigInteger.ONE).equals(BigInteger.ONE)) {
                    result = result.multiply(base).mod(mod);
                }
                base = base.multiply(base).mod(mod);
                exp = exp.shiftRight(1);
            }
            return result;
        }

        static boolean millerRabin(BigInteger n, BigInteger a) {
            if (n.mod(a).equals(BigInteger.ZERO)) return false;
            BigInteger d = n.subtract(BigInteger.ONE);
            int s = d.getLowestSetBit();
            d = d.shiftRight(s);
            BigInteger x = pow(a, d, n);
            if (x.equals(BigInteger.ONE) || x.equals(n.subtract(BigInteger.ONE))) return true;
            for (int r = 1; r < s; r++) {
                x = x.multiply(x).mod(n);
                if (x.equals(n.subtract(BigInteger.ONE))) return true;
            }
            return false;
        }

        static boolean isPrime(BigInteger n) {
            if (n.compareTo(BigInteger.valueOf(2)) < 0) return false;
            if (n.equals(BigInteger.TWO)) return true;
            if (n.mod(BigInteger.TWO).equals(BigInteger.ZERO)) return false;
            int[] bases = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37};
            for (int base : bases) {
                if (n.equals(BigInteger.valueOf(base))) return true;
                if (n.compareTo(BigInteger.valueOf(40)) > 0 && !millerRabin(n, BigInteger.valueOf(base))) return false;
            }
            return n.compareTo(BigInteger.valueOf(40)) > 0;
        }
    }

    static class PollardRho {

        static Random random = new Random();

        static void rec(BigInteger n, List<BigInteger> factors) {
            if (n.equals(BigInteger.ONE)) return;
            if (n.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
                factors.add(BigInteger.TWO);
                rec(n.divide(BigInteger.TWO), factors);
                return;
            }
            if (MillerRabin.isPrime(n)) {
                factors.add(n);
                return;
            }

            BigInteger a, b, c, g = n;
            while (g.equals(n)) {
                a = new BigInteger(n.bitLength(), random).mod(n.subtract(BigInteger.TWO)).add(BigInteger.TWO);
                b = a;
                c = new BigInteger(n.bitLength(), random).mod(n.subtract(BigInteger.TWO)).add(BigInteger.TWO);
                g = BigInteger.ONE;
                while (g.equals(BigInteger.ONE)) {
                    a = f(a, n, c);
                    b = f(f(b, n, c), n, c);
                    g = a.subtract(b).abs().gcd(n);
                }
            }
            rec(g, factors);
            rec(n.divide(g), factors);
        }

        static BigInteger f(BigInteger x, BigInteger n, BigInteger c) {
            return x.multiply(x).add(c).mod(n);
        }

        static List<BigInteger> factorize(BigInteger n) {
            List<BigInteger> factors = new ArrayList<>();
            rec(n, factors);
            return factors;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger n = scanner.nextBigInteger();
        scanner.close();

        List<BigInteger> factors = PollardRho.factorize(n);
        Set<BigInteger> uniqueFactors = new HashSet<>(factors);

        BigInteger count = BigInteger.ZERO;
        List<BigInteger> factorList = new ArrayList<>(uniqueFactors);
        int numFactors = factorList.size();

        for (int bit = 1; bit < (1 << numFactors); bit++) {
            BigInteger temp = BigInteger.ONE;
            for (int i = 0; i < numFactors; i++) {
                if ((bit & (1 << i)) != 0) {
                    temp = temp.multiply(factorList.get(i));
                }
            }
            int bitsCount = Integer.bitCount(bit);
            if ((bitsCount & 1) == 1) {
                count = count.add(n.divide(temp));
            } else {
                count = count.subtract(n.divide(temp));
            }
        }

        System.out.println(n.subtract(count));
    }
}
