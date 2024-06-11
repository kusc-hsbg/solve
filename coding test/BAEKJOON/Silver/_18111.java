import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _18111 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        int[] ground = new int[N * M];
        int maxHeight = 0;
        int minHeight = 256;
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int height = Integer.parseInt(st.nextToken());
                ground[i * M + j] = height;
                maxHeight = Math.max(maxHeight, height);
                minHeight = Math.min(minHeight, height);
            }
        }
        
        int[] time = new int[maxHeight + 1];
        int height = 0;
        
        for (int g = minHeight; g <= maxHeight; g++) {
            int block = B;
            time[g] = 0;
            
            for (int i : ground) {
                if (i <= g) {
                    time[g] += (g - i);
                    block -= (g - i);
                } else {
                    time[g] += 2 * (i - g);
                    block += (i - g);
                }
            }
            
            if (block >= 0 && (g == minHeight || time[g] <= time[height])) {
                height = g;
            }
        }
        
        System.out.println(time[height] + " " + height);
    }
}
