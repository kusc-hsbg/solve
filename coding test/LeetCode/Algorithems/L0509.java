class Solution {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }

        int prev1 = 0, prev2 = 1;
        for (int i = 2; i <= n; i++) {
            int current = prev1 + prev2;
            prev1 = prev2;
            prev2 = current;
        }

        return prev2;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();

        System.out.println(solver.fib(2)); // Output: 1
        System.out.println(solver.fib(3)); // Output: 2
        System.out.println(solver.fib(4)); // Output: 3
        System.out.println(solver.fib(5)); // Output: 5
        System.out.println(solver.fib(10)); // Output: 55
    }
}
