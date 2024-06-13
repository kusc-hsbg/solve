import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class _30804 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] tanghulu = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tanghulu[i] = Integer.parseInt(st.nextToken());
        }
        
        int left = 0;
        int right = 0;
        int maxLen = 0;
        int uniqueCount = 0;
        
        int[] fruitCount = new int[10];
        
        while (right < N) {
            if (fruitCount[tanghulu[right]] == 0) {
                uniqueCount++;
            }
            fruitCount[tanghulu[right]]++;
            right++;
            
            while (uniqueCount > 2) {
                fruitCount[tanghulu[left]]--;
                if (fruitCount[tanghulu[left]] == 0) {
                    uniqueCount--;
                }
                left++;
            }
            
            maxLen = Math.max(maxLen, right - left);
        }
        
        System.out.println(maxLen);
    }
}
