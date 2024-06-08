using System;

class Program
{
    static void Main()
    {
        long[] dp = new long[100];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 2;

        for (int i = 5; i < 100; i++)
        {
            dp[i] = dp[i - 1] + dp[i - 5];
        }

        if (int.TryParse(Console.ReadLine(), out int t))
        {
            for (int i = 0; i < t; i++)
            {
                string? input = Console.ReadLine();
                if (input != null && int.TryParse(input, out int n))
                {
                    if (n >= 1 && n <= 100)
                    {
                        Console.WriteLine(dp[n - 1]);
                    }
                }
            }
        }
    }
}
