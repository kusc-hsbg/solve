import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class _2243 {
    static final int MAX_FLAVOR = 1000000;
    static int[] fenwickTree = new int[MAX_FLAVOR + 1];
    static int[] frequencies = new int[MAX_FLAVOR + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringBuilder output = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int A = Integer.parseInt(tokenizer.nextToken());
            
            if (A == 1) {
                int B = Integer.parseInt(tokenizer.nextToken());
                int flavor = findKth(B);
                output.append(flavor).append('\n');
                update(flavor, -1);
            } else if (A == 2) {
                int B = Integer.parseInt(tokenizer.nextToken());
                int C = Integer.parseInt(tokenizer.nextToken());
                update(B, C);
            }
        }
        
        System.out.print(output);
    }

    static void update(int index, int delta) {
        frequencies[index] += delta;
        for (int i = index; i <= MAX_FLAVOR; i += i & -i) {
            fenwickTree[i] += delta;
        }
    }

    static int findKth(int k) {
        int low = 1, high = MAX_FLAVOR;
        while (low < high) {
            int mid = (low + high) / 2;
            if (prefixSum(mid) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    static int prefixSum(int index) {
        int sum = 0;
        for (int i = index; i > 0; i -= i & -i) {
            sum += fenwickTree[i];
        }
        return sum;
    }
}
