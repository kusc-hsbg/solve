class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n == 0) return 0;
        if (n == 1) return cost[0];

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution solver = new Solution();

        int[] cost1 = {10, 15, 20};
        System.out.println(solver.minCostClimbingStairs(cost1)); // Output: 15

        int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(solver.minCostClimbingStairs(cost2)); // Output: 6
    }
}
