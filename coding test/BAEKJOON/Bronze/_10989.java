import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] counts = new int[10001];

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            counts[num]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10000; i++) {
            while (counts[i] > 0) {
                sb.append(i).append('\n');
                counts[i]--;
            }
        }

        System.out.print(sb);
    }
}
