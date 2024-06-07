import java.util.Scanner;

public class _10830 {
    private static final int MOD = 1000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long b = scanner.nextLong();

        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int[][] result = matrixPower(matrix, b, n);
        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        scanner.close();
    }

    private static int[][] matrixPower(int[][] matrix, long exp, int size) {
        if (exp == 1) {
            return matrixMod(matrix, size);
        }

        int[][] halfPower = matrixPower(matrix, exp / 2, size);
        halfPower = matrixMultiply(halfPower, halfPower, size);

        if (exp % 2 == 1) {
            halfPower = matrixMultiply(halfPower, matrix, size);
        }

        return halfPower;
    }

    private static int[][] matrixMultiply(int[][] a, int[][] b, int size) {
        int[][] result = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                    result[i][j] %= MOD;
                }
            }
        }
        return result;
    }

    private static int[][] matrixMod(int[][] matrix, int size) {
        int[][] result = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = matrix[i][j] % MOD;
            }
        }
        return result;
    }
}
