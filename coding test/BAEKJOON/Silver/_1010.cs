using System;
class Program
{
    static void Main()
    {
        int T = int.Parse(Console.ReadLine());
        for (int t = 0; t < T; t++)
        {
            var input = Console.ReadLine().Split();
            int N = int.Parse(input[0]);
            int M = int.Parse(input[1]);
            Console.WriteLine(BinomialCoefficient(M, N));
        }
    }

    static long BinomialCoefficient(int n, int k)
    {
        if (k > n - k)
            k = n - k;
        long c = 1;
        for (int i = 0; i < k; i++)
        {
            c = c * (n - i) / (i + 1);
        }

        return c;
    }
}