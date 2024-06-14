import java.util.Scanner;

public class _1123 {
    static final long MOD = 600921647;
    static long[][] I;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            int n = sc.nextInt();
            long[] a = new long[n];
            long[] b = new long[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
                b[i] = sc.nextLong();
            }

            int m = sc.nextInt();
            char[][] c = new char[m][m];

            for (int i = 0; i < m; i++) {
                String row = sc.next();
                for (int j = 0; j < m; j++) {
                    c[i][j] = row.charAt(j);
                }
            }

            long A = sc.nextLong();
            long B = sc.nextLong();

            long[][] v = new long[9 * m][9 * m];
            I = new long[9 * m][9 * m];

            for (int i = 0; i < 9 * m; i++) {
                I[i][i] = 1;
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < 8; j++) {
                    v[i * 9 + j][i * 9 + j + 1] = 1;
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (c[(int) a[i]][j] == 'Y') {
                        v[(int) (a[i] * 9 + b[i] - 1)][j * 9]++;
                    }
                }
            }

            long[][] ans = multiply(power(v, A - 1), f(v, B - A));
            long result = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    result = (result + ans[j * 9][(int) (a[i] * 9 + b[i] - 1)]) % MOD;
                }
            }

            System.out.println(result);
        } finally {
            sc.close();
        }
    }

    static long[][] multiply(long[][] a, long[][] b) {
        int size = a.length;
        long[][] result = new long[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    result[i][j] = (result[i][j] + a[i][k] * b[k][j] % MOD) % MOD;
                }
            }
        }

        return result;
    }

    static long[][] add(long[][] a, long[][] b) {
        int size = a.length;
        long[][] result = new long[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = (a[i][j] + b[i][j]) % MOD;
            }
        }

        return result;
    }

    static long[][] subtract(long[][] a, long[][] b) {
        int size = a.length;
        long[][] result = new long[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = (a[i][j] - b[i][j] + MOD) % MOD;
            }
        }

        return result;
    }

    static long[][] power(long[][] a, long n) {
        int size = a.length;
        long[][] result = new long[size][size];

        if (n == 0) {
            for (int i = 0; i < size; i++) {
                result[i][i] = 1;
            }
            return result;
        }

        result = power(a, n / 2);
        result = multiply(result, result);

        if (n % 2 == 1) {
            result = multiply(result, a);
        }

        return result;
    }

    static long[][] f(long[][] a, long n) {
        if (n == 0) return I;

        long m = n / 2;
        long[][] tmp = f(a, m);

        if (n % 2 == 0) {
            long[][] ttmp = power(a, m);
            return subtract(multiply(add(ttmp, I), tmp), ttmp);
        } else {
            return multiply(add(power(a, m + 1), I), tmp);
        }
    }
}
