import java.util.Scanner;
//import java.util.ArrayList;
//import java.util.List;

public class _1241 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] circle = new int[N];
        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            circle[i] = scanner.nextInt();
        }

        int maxVal = 0;
        for (int num : circle) {
            if (num > maxVal) {
                maxVal = num;
            }
        }
        int[] matrix = new int[maxVal + 1];
        for (int num : circle) {
            matrix[num]++;
        }

        for (int i = 0; i < N; i++) {
            int k = 1;
            while (k * k <= circle[i]) {
                if (circle[i] % k == 0) {
                    if (k * k != circle[i]) {
                        result[i] += matrix[k] + matrix[circle[i] / k];
                    } else {
                        result[i] += matrix[k];
                    }
                }
                k++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(result[i] - 1).append("\n");
        }
        System.out.print(sb.toString());
        scanner.close();
    }
}