class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        Solution solver = new Solution();

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        solver.merge(nums1, m, nums2, n);
        for (int num : nums1) {
            System.out.print(num + " ");
        }
        // Output: 1 2 2 3 5 6

        System.out.println();

        int[] nums1_2 = {1};
        int m_2 = 1;
        int[] nums2_2 = {};
        int n_2 = 0;
        solver.merge(nums1_2, m_2, nums2_2, n_2);
        for (int num : nums1_2) {
            System.out.print(num + " ");
        }
        // Output: 1

        System.out.println();

        int[] nums1_3 = {0};
        int m_3 = 0;
        int[] nums2_3 = {1};
        int n_3 = 1;
        solver.merge(nums1_3, m_3, nums2_3, n_3);
        for (int num : nums1_3) {
            System.out.print(num + " ");
        }
        // Output: 1
    }
}
