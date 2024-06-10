import java.util.Arrays;
import java.util.Scanner;

public class _1920 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int[] arrayA = new int[N];
        for (int i = 0; i < N; i++) {
            arrayA[i] = scanner.nextInt();
        }
        
        int M = scanner.nextInt();
        int[] queries = new int[M];
        for (int i = 0; i < M; i++) {
            queries[i] = scanner.nextInt();
        }
        
        scanner.close();
        
        Arrays.sort(arrayA);
        
        StringBuilder results = new StringBuilder();
        for (int i = 0; i < M; i++) {
            if (binarySearch(arrayA, queries[i])) {
                results.append(1).append("\n");
            } else {
                results.append(0).append("\n");
            }
        }
        
        System.out.print(results.toString());
    }
    
    private static boolean binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == target) {
                return true;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return false;
    }
}