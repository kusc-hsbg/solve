class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        
        // Initialize dp array with the last row of the matrix
        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = matrix[n - 1][i];
        }

        // Iterate from the second last row to the top row
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int best = dp[i + 1][j];
                if (j > 0) {
                    best = Math.min(best, dp[i + 1][j - 1]);
                }
                if (j < n - 1) {
                    best = Math.min(best, dp[i + 1][j + 1]);
                }
                dp[i][j] = matrix[i][j] + best;
            }
        }

        // Find the minimum value in the first row
        int minPathSum = dp[0][0];
        for (int j = 1; j < n; j++) {
            minPathSum = Math.min(minPathSum, dp[0][j]);
        }

        return minPathSum;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();

        int[][] matrix1 = {
            {2, 1, 3},
            {6, 5, 4},
            {7, 8, 9}
        };
        System.out.println(solver.minFallingPathSum(matrix1)); // Output: 13

        int[][] matrix2 = {
            {-19, 57},
            {-40, -5}
        };
        System.out.println(solver.minFallingPathSum(matrix2)); // Output: -59
    }
}
