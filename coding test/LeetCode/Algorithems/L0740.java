import java.util.HashMap;
import java.util.Map;

class Solution {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> valueMap = new HashMap<>();
        int maxNum = 0;

        // Step 1: Create a map to store the total points for each value
        for (int num : nums) {
            valueMap.put(num, valueMap.getOrDefault(num, 0) + num);
            maxNum = Math.max(maxNum, num);
        }

        // Step 2: Use dynamic programming to find the maximum points
        int[] dp = new int[maxNum + 1];
        dp[1] = valueMap.getOrDefault(1, 0);

        for (int i = 2; i <= maxNum; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + valueMap.getOrDefault(i, 0));
        }

        return dp[maxNum];
    }

    public static void main(String[] args) {
        Solution solver = new Solution();

        int[] nums1 = {3, 4, 2};
        System.out.println(solver.deleteAndEarn(nums1)); // Output: 6

        int[] nums2 = {2, 2, 3, 3, 3, 4};
        System.out.println(solver.deleteAndEarn(nums2)); // Output: 9
    }
}
