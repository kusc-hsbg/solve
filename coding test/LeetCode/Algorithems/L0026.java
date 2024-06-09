class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int uniqueIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[uniqueIndex] = nums[i];
                uniqueIndex++;
            }
        }
        return uniqueIndex;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();

        int[] nums1 = {1, 1, 2};
        int k1 = solver.removeDuplicates(nums1);
        System.out.println(k1); // 2
        for (int i = 0; i < k1; i++) {
            System.out.print(nums1[i] + " "); // 1 2
        }
        System.out.println();

        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k2 = solver.removeDuplicates(nums2);
        System.out.println(k2); // 5
        for (int i = 0; i < k2; i++) {
            System.out.print(nums2[i] + " "); // 0 1 2 3 4
        }
    }
}
