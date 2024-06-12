import java.util.*;

public class _1799 {
    static int N;
    static int[][] board;
    static boolean[][] visited;
    static int maxBishops;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        board = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = scanner.nextInt();
            }
        }
        scanner.close();

        int result = placeBishops(0, true) + placeBishops(0, false);
        System.out.println(result);
    }

    static int placeBishops(int start, boolean isBlack) {
        List<int[]> positions = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1 && ((i + j) % 2 == (isBlack ? 0 : 1))) {
                    positions.add(new int[] {i, j});
                }
            }
        }
        
        boolean[] primaryDiag = new boolean[2 * N];
        boolean[] secondaryDiag = new boolean[2 * N];
        
        return backtrack(positions, 0, primaryDiag, secondaryDiag);
    }
    
    static int backtrack(List<int[]> positions, int index, boolean[] primaryDiag, boolean[] secondaryDiag) {
        if (index == positions.size()) {
            return 0;
        }
        
        int[] pos = positions.get(index);
        int r = pos[0];
        int c = pos[1];
        
        int maxCount = 0;
        
        if (!primaryDiag[r - c + N] && !secondaryDiag[r + c]) {
            primaryDiag[r - c + N] = true;
            secondaryDiag[r + c] = true;
            
            maxCount = 1 + backtrack(positions, index + 1, primaryDiag, secondaryDiag);
            
            primaryDiag[r - c + N] = false;
            secondaryDiag[r + c] = false;
        }
        
        maxCount = Math.max(maxCount, backtrack(positions, index + 1, primaryDiag, secondaryDiag));
        
        return maxCount;
    }
}
