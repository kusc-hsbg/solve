import java.util.HashMap;
import java.util.Scanner;

public class _1351 {
    private static HashMap<Long, Long> memo = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long N = scanner.nextLong();
        long P = scanner.nextLong();
        long Q = scanner.nextLong();
        scanner.close();

        memo.put(0L, 1L);

        System.out.println(getA(N, P, Q));
    }

    private static long getA(long i, long P, long Q) {
        if (memo.containsKey(i)) {
            return memo.get(i);
        }

        long result = getA(i / P, P, Q) + getA(i / Q, P, Q);
        memo.put(i, result);

        return result;
    }
}
