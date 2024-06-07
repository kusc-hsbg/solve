import java.io.*;
import java.util.*;

public class _13977 {
    static final int MOD = 1000000007;
    
    private static long[] factorial;
    private static long[] factorialInv;
    
    private static long modInv(long a, int mod) {
        long m0 = mod, x0 = 0, x1 = 1;
        if (mod == 1)
            return 0;
        while (a > 1) {
            long q = a / mod;
            long t = mod;
            mod = (int) (a % mod);  // Convert to int here for modulus operation
            a = t;
            t = x0;
            x0 = x1 - q * x0;
            x1 = t;
        }
        if (x1 < 0)
            x1 += m0;
        return x1;
    }
    
    private static void preprocess(int maxN) {
        factorial = new long[maxN + 1];
        factorialInv = new long[maxN + 1];
        factorial[0] = 1;
        for (int i = 1; i <= maxN; i++) {
            factorial[i] = factorial[i - 1] * i % MOD;
        }
        factorialInv[maxN] = modInv(factorial[maxN], MOD);
        for (int i = maxN - 1; i >= 0; i--) {
            factorialInv[i] = factorialInv[i + 1] * (i + 1) % MOD;
        }
    }
    
    private static long binomial(int n, int k) {
        if (k > n) return 0;
        return factorial[n] * (factorialInv[k] * factorialInv[n - k] % MOD) % MOD;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(reader.readLine());
        ArrayList<Integer> queries = new ArrayList<>();
        int maxN = 0;
        
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            queries.add(n);
            queries.add(k);
            maxN = Math.max(maxN, n);
        }
        
        preprocess(maxN);
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < queries.size(); i += 2) {
            int n = queries.get(i);
            int k = queries.get(i + 1);
            result.append(binomial(n, k)).append("\n");
        }
        
        System.out.print(result.toString());
    }
}
