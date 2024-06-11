import java.util.Arrays;
import java.util.Scanner;

public class _2473 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }
        scanner.close();

        Arrays.sort(a);
        
        long ret = Long.MAX_VALUE;
        long[] ans = new long[3];

        for (int i = 0; i < n - 2; i++) {
            int st = i + 1;
            int en = n - 1;
            while (st < en) {
                long v = a[i] + a[st] + a[en];
                if (Math.abs(v) < ret) {
                    ret = Math.abs(v);
                    ans[0] = a[i];
                    ans[1] = a[st];
                    ans[2] = a[en];
                }
                if (v < 0) {
                    st++;
                } else {
                    en--;
                }
            }
        }

        Arrays.sort(ans);
        System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
    }
}
