import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int res = 0;
        int[] stack = new int[K];
        int top = -1;

        for (int i = 0; i < K; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                res -= stack[top--];
            } else {
                stack[++top] = n;
                res += n;
            }
        }

        System.out.println(res);
    }
}
