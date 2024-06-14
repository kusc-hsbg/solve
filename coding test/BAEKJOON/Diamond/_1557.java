import java.util.Scanner;

public class _1557 {
    static final long MAX = (long) 1e10;
    static final int SIZE = 1000010;
    static int[] mobius = new int[SIZE];

    static void initMobius() {
        mobius[1] = 1;
        for (int i = 1; i < SIZE; i++) {
            for (int j = 2 * i; j < SIZE; j += i) {
                mobius[j] -= mobius[i];
            }
        }
    }

    static long compute(long n) {
        long counts = 0;
        for (long i = 1; i * i <= n; i++) {
            counts += mobius[(int)i] * (n / (i * i));
        }
        return counts;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            initMobius();
            long k = sc.nextLong();
            long l = 0, r = MAX;
            while (l < r - 1) {
                long mid = (l + r) / 2;
                if (compute(mid) < k) {
                    l = mid;
                } else {
                    r = mid;
                }
            }
            System.out.println(r);
        } finally {
            sc.close();
        }
    }
}
