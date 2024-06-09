class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            result.append(sum % 2);
            carry = sum / 2;
        }

        if (carry != 0) {
            result.append(carry);
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solver = new Solution();

        String a1 = "11";
        String b1 = "1";
        System.out.println(solver.addBinary(a1, b1)); // Output: "100"

        String a2 = "1010";
        String b2 = "1011";
        System.out.println(solver.addBinary(a2, b2)); // Output: "10101"
    }
}
