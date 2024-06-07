import java.util.Scanner;

public class _1029 {
    static int N;
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        arr = new int[N][N];
        dp = new int[1 << N][N];
        
        for (int i = 0; i < N; i++) {
            String str = scanner.next();
            for (int j = 0; j < str.length(); j++) {
                arr[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }
        scanner.close();

        System.out.println(DFS(0, 0, 0) + 1);
    }

    static int DFS(int cur, int price, int bits) {
        bits |= (1 << cur);

        if (dp[bits][cur] != 0) 
            return dp[bits][cur];

        for (int next = 1; next < N; next++) {
            if ((bits & (1 << next)) == 0 && arr[cur][next] >= price) 
                dp[bits][cur] = Math.max(dp[bits][cur], DFS(next, arr[cur][next], bits) + 1);
        }

        return dp[bits][cur];
    }
}
