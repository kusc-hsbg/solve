import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class _2166 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            int[] x = new int[N];
            int[] y = new int[N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                x[i] = Integer.parseInt(st.nextToken());
                y[i] = Integer.parseInt(st.nextToken());
            }

            double area = calculatePolygonArea(x, y, N);
            System.out.printf("%.1f", area);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double calculatePolygonArea(int[] x, int[] y, int n) {
        long sum1 = 0;
        long sum2 = 0;

        for (int i = 0; i < n; i++) {
            sum1 += (long) x[i] * y[(i + 1) % n];
            sum2 += (long) y[i] * x[(i + 1) % n];
        }

        return Math.abs(sum1 - sum2) / 2.0;
    }
}
