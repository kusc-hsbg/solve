import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        Solution solver = new Solution();
        int[] result = solver.twoSum(new int[] {2, 7, 11, 15}, 9);
        System.out.println("[" + result[0] + ", " + result[1] + "]");

        result = solver.twoSum(new int[] {3, 2, 4}, 6);
        System.out.println("[" + result[0] + ", " + result[1] + "]");

        result = solver.twoSum(new int[] {3, 3}, 6);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }
}
