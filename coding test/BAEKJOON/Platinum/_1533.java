import java.util.Scanner;
// import java.util.Arrays;

public class _1533 {
    static final long MOD = 1000003;

    static class Matrix {
        int size;
        long[][] arr;

        Matrix() {
            size = 0;
        }

        Matrix(int n) {
            size = n;
            arr = new long[n][n];
        }

        Matrix multiply(Matrix x) {
            Matrix ret = new Matrix(size);
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    for (int k = 0; k < size; k++) {
                        ret.arr[i][j] = (ret.arr[i][j] + this.arr[i][k] * x.arr[k][j]) % MOD;
                    }
                }
            }
            return ret;
        }
    }

    static Matrix powmat(Matrix a, long b) {
        if (b == 1) return a;
        Matrix ret = powmat(a, b / 2);
        ret = ret.multiply(ret);
        if (b % 2 == 1) ret = ret.multiply(a);
        return ret;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt() - 1;
        int e = sc.nextInt() - 1;
        long t = sc.nextLong();
        sc.nextLine();

        Matrix mat = new Matrix(n * 5);
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < 5; j++) {
                mat.arr[i * 5 + j][i * 5 + j - 1] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < n; j++) {
                int tt = str.charAt(j) - '0';
                if (tt == 1) mat.arr[i * 5][j * 5] = 1;
                else if (tt > 1) mat.arr[i * 5][j * 5 + tt - 1] = 1;
            }
        }

        Matrix ans = powmat(mat, t);
        System.out.println(ans.arr[s * 5][e * 5]);

        sc.close();
    }
}
