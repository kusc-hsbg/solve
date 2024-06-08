public class _4673 {
    public static void main(String[] args) {
        final int LIMIT = 10000;
        boolean[] isNotSelfNumber = new boolean[LIMIT + 1];

        for (int i = 1; i <= LIMIT; i++) {
            int dn = d(i);
            if (dn <= LIMIT) {
                isNotSelfNumber[dn] = true;
            }
        }

        for (int i = 1; i <= LIMIT; i++) {
            if (!isNotSelfNumber[i]) {
                System.out.println(i);
            }
        }
    }

    public static int d(int n) {
        int sum = n;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
