import java.util.List;
import java.util.ArrayList;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        
        // Initialize dp with the last row of the triangle
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }
        
        // Iterate from the second last row to the top row
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        
        return dp[0];
    }

    public static void main(String[] args) {
        Solution solver = new Solution();
        
        List<List<Integer>> triangle1 = new ArrayList<>();
        triangle1.add(List.of(2));
        triangle1.add(List.of(3, 4));
        triangle1.add(List.of(6, 5, 7));
        triangle1.add(List.of(4, 1, 8, 3));
        System.out.println(solver.minimumTotal(triangle1)); // Output: 11

        List<List<Integer>> triangle2 = new ArrayList<>();
        triangle2.add(List.of(-10));
        System.out.println(solver.minimumTotal(triangle2)); // Output: -10
    }
}
