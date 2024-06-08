import java.util.Scanner;

public class _1086 {
    static int n, k;
    static String[] s;
    static long[][] dp;
    static int[] cache;
    static int[] cachestr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }
        k = sc.nextInt();

        sc.close(); // Scanner 객체 닫기

        dp = new long[1 << n][k];
        cache = new int[51];
        cachestr = new int[n];

        dp[0][0] = 1;

        cache[0] = 1 % k;
        for (int i = 1; i < 51; i++) {
            cache[i] = (cache[i - 1] * 10) % k;
        }

        for (int i = 0; i < n; i++) {
            cachestr[i] = getMod(s[i], k);
        }

        solution();

        long denominator = 1, numerator;

        for (int i = 1; i <= n; i++) {
            denominator *= i;
        }

        numerator = dp[(1 << n) - 1][0];
        long gcd = GCD(numerator, denominator);

        System.out.println((numerator / gcd) + "/" + (denominator / gcd));
    }

    static int getMod(String s, int divisor) {
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            ret *= 10;
            ret += s.charAt(i) - '0';
            ret %= divisor;
        }
        return ret;
    }

    static long GCD(long lhs, long rhs) {
        long big = Math.max(lhs, rhs);
        long small = Math.min(lhs, rhs);

        while (small != 0) {
            long remainder = big % small;
            big = small;
            small = remainder;
        }
        return big;
    }

    static void solution() {
        for (int cur = 0; cur < (1 << n); cur++) {
            for (int i = 0; i < n; i++) {
                if ((cur & (1 << i)) == 0) {
                    int nextState = cur | (1 << i);

                    for (int j = 0; j < k; j++) {
                        int nextK = ((j * cache[s[i].length()]) % k + cachestr[i]) % k;
                        dp[nextState][nextK] += dp[cur][j];
                    }
                }
            }
        }
    }
}
