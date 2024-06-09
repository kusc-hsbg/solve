public class L0744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return letters[left % letters.length];
    }

    public static void main(String[] args) {
        L0744 sol = new L0744();
        
        char[] letters1 = {'c', 'f', 'j'};
        char target1 = 'a';
        System.out.println("Output: " + sol.nextGreatestLetter(letters1, target1));  // Output: c

        // Test case 2
        char[] letters2 = {'c', 'f', 'j'};
        char target2 = 'c';
        System.out.println("Output: " + sol.nextGreatestLetter(letters2, target2));  // Output: f

        // Test case 3
        char[] letters3 = {'x', 'x', 'y', 'y'};
        char target3 = 'z';
        System.out.println("Output: " + sol.nextGreatestLetter(letters3, target3));  // Output: x
    }
}
