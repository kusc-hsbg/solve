class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newNumber = new int[digits.length + 1];
        newNumber[0] = 1;
        return newNumber;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();

        int[] digits1 = {1, 2, 3};
        int[] result1 = solver.plusOne(digits1);
        for (int digit : result1) {
            System.out.print(digit + " ");
        }
        // Output: 1 2 4
        System.out.println();

        int[] digits2 = {4, 3, 2, 1};
        int[] result2 = solver.plusOne(digits2);
        for (int digit : result2) {
            System.out.print(digit + " ");
        }
        // Output: 4 3 2 2
        System.out.println();

        int[] digits3 = {9};
        int[] result3 = solver.plusOne(digits3);
        for (int digit : result3) {
            System.out.print(digit + " ");
        }
        // Output: 1 0
        System.out.println();
    }
}
