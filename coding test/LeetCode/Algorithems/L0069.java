class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int left = 1, right = x, result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();

        int x1 = 4;
        System.out.println(solver.mySqrt(x1)); // Output: 2

        int x2 = 8;
        System.out.println(solver.mySqrt(x2)); // Output: 2
    }
}
