import java.util.*;

public class _1148 {

    static final int MAX_WORDS = 200000;
    static final int ALPHABET_SIZE = 26;
    static int[][] A = new int[MAX_WORDS][ALPHABET_SIZE];
    static int[] B = new int[ALPHABET_SIZE];
    static int[] cnt = new int[ALPHABET_SIZE];
    static boolean[] visit = new boolean[ALPHABET_SIZE];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int len = 0;
        while (true) {
            String str = scanner.next();
            if (str.equals("-")) break;
            for (int j = 0; j < str.length(); j++) {
                A[len][str.charAt(j) - 'A'] += 1;
            }
            len++;
        }

        while (true) {
            Arrays.fill(B, 0);
            Arrays.fill(cnt, -1);

            String str = scanner.next();
            if (str.equals("#")) break;

            for (int j = 0; j < str.length(); j++) {
                B[str.charAt(j) - 'A'] += 1;
                cnt[str.charAt(j) - 'A'] = 0;
            }

            for (int j = 0; j < len; j++) {
                boolean flag = true;
                for (int k = 0; k < ALPHABET_SIZE; k++) {
                    if (B[k] - A[j][k] < 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    for (int k = 0; k < str.length(); k++) {
                        if (A[j][str.charAt(k) - 'A'] > 0 && !visit[str.charAt(k) - 'A']) {
                            cnt[str.charAt(k) - 'A'] += 1;
                            visit[str.charAt(k) - 'A'] = true;
                        }
                    }
                }
                Arrays.fill(visit, false);
            }

            int Min = Integer.MAX_VALUE;
            int Max = Integer.MIN_VALUE;
            for (int j = 0; j < ALPHABET_SIZE; j++) {
                if (Min >= cnt[j] && cnt[j] != -1) Min = cnt[j];
                if (Max <= cnt[j] && cnt[j] != -1) Max = cnt[j];
            }

            StringBuilder ans1 = new StringBuilder();
            StringBuilder ans2 = new StringBuilder();
            for (int j = 0; j < ALPHABET_SIZE; j++) {
                if (Min == cnt[j]) ans1.append((char) (j + 'A'));
                if (Max == cnt[j]) ans2.append((char) (j + 'A'));
            }
            System.out.println(ans1 + " " + Min + " " + ans2 + " " + Max);
        }

        scanner.close();
    }
}
