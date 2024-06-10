import java.util.Scanner;

public class _1654 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int K = scanner.nextInt();
        int N = scanner.nextInt();
        long[] lengths = new long[K];
        long maxLen = 0;

        for (int i = 0; i < K; i++) {
            lengths[i] = scanner.nextLong();
            if (lengths[i] > maxLen) {
                maxLen = lengths[i];
            }
        }

        scanner.close();
        long left = 1;
        long right = maxLen;
        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (canMakeN(lengths, N, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }

    private static boolean canMakeN(long[] lengths, int N, long len) {
        int count = 0;
        for (long length : lengths) {
            count += length / len;
        }
        return count >= N;
    }
}
