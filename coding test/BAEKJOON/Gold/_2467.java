import java.util.Scanner;

public class _2467 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int[] properties = new int[N];
        
        for (int i = 0; i < N; i++) {
            properties[i] = scanner.nextInt();
        }
        
        int left = 0;
        int right = N - 1;
        int closestSum = Integer.MAX_VALUE;
        int resultLeft = left;
        int resultRight = right;
        
        while (left < right) {
            int sum = properties[left] + properties[right];
            
            if (Math.abs(sum) < Math.abs(closestSum)) {
                closestSum = sum;
                resultLeft = left;
                resultRight = right;
            }
            
            if (sum < 0) {
                left++;
            } else if (sum > 0) {
                right--;
            } else {
                break;
            }
        }
        System.out.println(properties[resultLeft] + " " + properties[resultRight]);
        
        scanner.close();
    }
}