import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1067 {
    static class Complex {
        double real, imag;

        public Complex(double real, double imag) {
            this.real = real;
            this.imag = imag;
        }

        public Complex add(Complex other) {
            return new Complex(this.real + other.real, this.imag + other.imag);
        }

        public Complex subtract(Complex other) {
            return new Complex(this.real - other.real, this.imag - other.imag);
        }

        public Complex multiply(Complex other) {
            return new Complex(this.real * other.real - this.imag * other.imag,
                               this.real * other.imag + this.imag * other.real);
        }

        public Complex divide(double value) {
            return new Complex(this.real / value, this.imag / value);
        }
    }

    public static void fft(Complex[] a, boolean invert) {
        int n = a.length;
        int j = 0;
        for (int i = 1; i < n; i++) {
            int bit = n >> 1;
            while (j >= bit) {
                j -= bit;
                bit >>= 1;
            }
            j += bit;
            if (i < j) {
                Complex temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        double ang = 2 * Math.PI / n * (invert ? -1 : 1);
        Complex[] roots = new Complex[n / 2];
        for (int i = 0; i < n / 2; i++) {
            roots[i] = new Complex(Math.cos(ang * i), Math.sin(ang * i));
        }

        for (int len = 2; len <= n; len <<= 1) {
            int step = n / len;
            for (int i = 0; i < n; i += len) {
                for (int k = 0; k < len / 2; k++) {
                    Complex u = a[i + k];
                    Complex v = a[i + k + len / 2].multiply(roots[step * k]);
                    a[i + k] = u.add(v);
                    a[i + k + len / 2] = u.subtract(v);
                }
            }
        }

        if (invert) {
            for (int i = 0; i < n; i++) {
                a[i] = a[i].divide(n);
            }
        }
    }

    public static long[] multiply(long[] v, long[] w) {
        int n = 1;
        while (n < v.length + w.length) {
            n <<= 1;
        }

        Complex[] fv = new Complex[n];
        Complex[] fw = new Complex[n];
        for (int i = 0; i < v.length; i++) {
            fv[i] = new Complex(v[i], 0);
        }
        for (int i = v.length; i < n; i++) {
            fv[i] = new Complex(0, 0);
        }
        for (int i = 0; i < w.length; i++) {
            fw[i] = new Complex(w[i], 0);
        }
        for (int i = w.length; i < n; i++) {
            fw[i] = new Complex(0, 0);
        }

        fft(fv, false);
        fft(fw, false);
        for (int i = 0; i < n; i++) {
            fv[i] = fv[i].multiply(fw[i]);
        }
        fft(fv, true);

        long[] result = new long[n];
        for (int i = 0; i < n; i++) {
            result[i] = Math.round(fv[i].real);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        long[] a = new long[n * 2];
        long[] b = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(st.nextToken());
            a[i + n] = a[i];
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            b[n - i] = Long.parseLong(st.nextToken());
        }

        long[] result = multiply(a, b);
        long ans = 0;
        for (long value : result) {
            ans = Math.max(ans, value);
        }

        System.out.println(ans);
    }
}
