import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        
        long[] heights = new long[N];
        st = new StringTokenizer(br.readLine());
        
        long max = 0;
        for (int i = 0; i < N; i++) {
            heights[i] = Long.parseLong(st.nextToken());
            if (heights[i] > max) {
                max = heights[i];
            }
        }
        
        long low = 0;
        long high = max;
        long result = 0;
        
        while (low <= high) {
            long mid = (low + high) / 2;
            long total = 0;
            
            for (int i = 0; i < N; i++) {
                if (heights[i] > mid) {
                    total += heights[i] - mid;
                }
            }
            
            if (total >= M) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        System.out.println(result);
    }
}
