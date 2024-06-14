import java.util.*;
import java.io.*;

public class _1671 {
    static int n;
    static List<int[]> lst = new ArrayList<>();
    static int[][] check;
    static int[] chain;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        lst.add(new int[]{0, 0, 0}); 
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int it = Integer.parseInt(st.nextToken());
            lst.add(new int[]{s, v, it});
        }
        
        check = new int[n+1][n+1];
        chain = new int[n+1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                if (lst.get(i)[0] == lst.get(j)[0] && lst.get(i)[1] == lst.get(j)[1] && lst.get(i)[2] == lst.get(j)[2] && i > j) continue;
                if (lst.get(i)[0] >= lst.get(j)[0] && lst.get(i)[1] >= lst.get(j)[1] && lst.get(i)[2] >= lst.get(j)[2]) {
                    check[i][j] = 1;
                }
            }
        }
        
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j <= n; j++) {
                visited = new boolean[n+1];
                sol(j);
            }
        }
        
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (chain[i] == 0) {
                count++;
            }
        }
        System.out.println(count);
    }
    
    static boolean sol(int x) {
        if (visited[x]) {
            return false;
        }
        
        visited[x] = true;
        
        for (int i = 1; i <= n; i++) {
            if (check[x][i] == 1) {
                if (chain[i] == 0 || sol(chain[i])) {
                    chain[i] = x;
                    return true;
                }
            }
        }
        
        return false;
    }
}
