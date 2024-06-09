import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }
        
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }
}

public class L0283 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        Solution solution = new Solution();
        solution.moveZeroes(arr);
        
        System.out.println(Arrays.toString(arr));
        
        scanner.close();
    }
}
