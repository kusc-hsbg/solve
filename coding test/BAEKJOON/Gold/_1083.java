import java.util.Scanner;

public class _1083 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
        }
        int S = scanner.nextInt();
        scanner.close();
        
        for (int i = 0; i < N - 1 && S > 0; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < N && j - i <= S; j++) {
                if (array[j] > array[maxIndex]) {
                    maxIndex = j;
                }
            }
            
            for (int j = maxIndex; j > i; j--) {
                int temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
                S--;
            }
        }
        
        for (int i = 0; i < N; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
