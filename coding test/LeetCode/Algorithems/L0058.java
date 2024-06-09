class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        boolean charFound = false;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                charFound = true;
                length++;
            } else {
                if (charFound) {
                    return length;
                }
            }
        }
        return length;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();

        String s1 = "Hello World";
        System.out.println(solver.lengthOfLastWord(s1)); // Output: 5

        String s2 = "   fly me   to   the moon  ";
        System.out.println(solver.lengthOfLastWord(s2)); // Output: 4

        String s3 = "luffy is still joyboy";
        System.out.println(solver.lengthOfLastWord(s3)); // Output: 6
    }
}
