#define _USE_MATH_DEFINES
using System;
using System.Collections.Generic;
using System.Linq;
using System.Numerics;

class Program
{
    static void FFT(List<Complex> a, bool invert)
    {
        int n = a.Count;
        for (int i = 1, j = 0; i < n; ++i)
        {
            int bit = n >> 1;
            while ((j ^= bit) < bit) bit >>= 1;
            if (i < j)
            {
                var temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        for (int len = 2; len <= n; len <<= 1)
        {
            double ang = 2 * Math.PI / len * (invert ? -1 : 1);
            Complex wlen = new Complex(Math.Cos(ang), Math.Sin(ang));
            for (int i = 0; i < n; i += len)
            {
                Complex w = Complex.One;
                for (int j = 0; j < len / 2; ++j)
                {
                    Complex u = a[i + j];
                    Complex v = a[i + j + len / 2] * w;
                    a[i + j] = u + v;
                    a[i + j + len / 2] = u - v;
                    w *= wlen;
                }
            }
        }
        if (invert)
        {
            for (int i = 0; i < n; ++i)
                a[i] /= n;
        }
    }

    static List<Complex> Multiply(List<Complex> f, List<Complex> g)
    {
        int n = 1;
        while (n < Math.Max(f.Count, g.Count)) n <<= 1;
        n <<= 1;

        List<Complex> pf = new List<Complex>(f);
        List<Complex> pg = new List<Complex>(g);
        pf.AddRange(Enumerable.Repeat(new Complex(0, 0), n - pf.Count));
        pg.AddRange(Enumerable.Repeat(new Complex(0, 0), n - pg.Count));

        FFT(pf, false);
        FFT(pg, false);

        List<Complex> ret = new List<Complex>(new Complex[n]);
        for (int i = 0; i < n; ++i) ret[i] = pf[i] * pg[i];

        FFT(ret, true);
        for (int i = 0; i < n; ++i) ret[i] = new Complex(Math.Round(ret[i].Real), 0);
        
        return ret;
    }

    static void Main()
    {
        string input = Console.ReadLine() ?? "0";
        int N = int.Parse(input);

        List<int> tmp = new List<int>(new int[N]);
        List<int> sq = new List<int>(new int[N]);
        List<Complex> p = new List<Complex>(new Complex[N]);

        for (int i = 1; i < N; ++i)
        {
            tmp[(int)((1L * i * i) % N)]++;
            sq[(int)((2L * i * i) % N)]++;
        }

        for (int i = 0; i < N; ++i) p[i] = new Complex(tmp[i], 0);

        List<Complex> mul = Multiply(p, p);
        long ans = 0;

        for (int i = 1; i < N; ++i)
        {
            int k = (int)((1L * i * i) % N);
            int total = (int)mul[k].Real + (int)mul[N + k].Real;
            int eq = sq[k];
            ans += (total - eq) / 2 + eq;
        }

        Console.WriteLine(ans);
    }
}
