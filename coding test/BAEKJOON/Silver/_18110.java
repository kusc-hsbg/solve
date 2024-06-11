import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class _18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine().trim());

        if (n == 0) {
            bw.write("0\n");
            bw.flush();
            return;
        }

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine().trim());
        }

        Arrays.sort(nums);

        int out = (int) Math.round(n * 0.15);
        double sum = 0;

        for (int i = out; i < n - out; i++) {
            sum += nums[i];
        }

        int result = (int) Math.round(sum / (n - out * 2));
        bw.write(result + "\n");
        bw.flush();
    }
}
