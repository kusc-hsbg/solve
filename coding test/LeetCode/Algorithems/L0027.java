class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();

        int[] nums1 = {3, 2, 2, 3};
        int k1 = solver.removeElement(nums1, 3);
        System.out.println(k1); // 2
        for (int i = 0; i < k1; i++) {
            System.out.print(nums1[i] + " "); // 2 2
        }
        System.out.println();

        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int k2 = solver.removeElement(nums2, 2);
        System.out.println(k2); // 5
        for (int i = 0; i < k2; i++) {
            System.out.print(nums2[i] + " "); // 0 1 3 0 4
        }
    }
}
