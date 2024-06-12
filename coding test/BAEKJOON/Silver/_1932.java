import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < n; i++) {
            arr[i][0] += arr[i - 1][0];
            for (int j = 1; j < i; j++) {
                arr[i][j] += Math.max(arr[i - 1][j - 1], arr[i - 1][j]);
            }
            arr[i][i] += arr[i - 1][i - 1];
        }

        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            if (arr[n - 1][i] > maxSum) {
                maxSum = arr[n - 1][i];
            }
        }

        System.out.println(maxSum);
    }
}