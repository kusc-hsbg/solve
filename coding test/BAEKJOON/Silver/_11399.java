import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] times = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(times);
        
        int totalTime = 0;
        int accumulatedTime = 0;
        
        for (int time : times) {
            accumulatedTime += time;
            totalTime += accumulatedTime;
        }
        
        System.out.println(totalTime);
    }
}
