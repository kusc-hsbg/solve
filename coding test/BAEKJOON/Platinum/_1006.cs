using System;
using System.Linq;

class Program
{
    const int INF = 987654321;

    static void Solve(int n, int w, int[,] arr, int[,] dp)
    {
        for (int i = 2; i <= n; ++i)
        {
            int up = arr[0, i - 1] + arr[0, i] <= w ? 1 : 2;
            int down = arr[1, i - 1] + arr[1, i] <= w ? 1 : 2;
            int ver = arr[0, i] + arr[1, i] <= w ? 1 : 2;

            dp[i, 0] = Math.Min(Math.Min(dp[i - 1, 0] + ver, dp[i - 2, 0] + up + down), Math.Min(dp[i - 1, 1] + up + 1, dp[i - 1, 2] + 1 + down));
            dp[i, 1] = Math.Min(dp[i - 1, 2] + down, dp[i - 1, 0] + 1);
            dp[i, 2] = Math.Min(dp[i - 1, 1] + up, dp[i - 1, 0] + 1);
        }
    }

    static void Main()
    {
        int t = int.Parse(Console.ReadLine());

        while (t-- > 0)
        {
            var firstLine = Console.ReadLine().Split().Select(int.Parse).ToArray();
            int n = firstLine[0];
            int w = firstLine[1];

            int[,] arr = new int[2, n + 1];
            int[,] dp = new int[n + 1, 3];

            for (int i = 0; i < 2; ++i)
            {
                var line = Console.ReadLine().Split().Select(int.Parse).ToArray();
                for (int j = 1; j <= n; ++j)
                {
                    arr[i, j] = line[j - 1];
                }
            }

            int t_up = arr[0, 1];
            int t_down = arr[1, 1];

            int ans = INF;

            dp[1, 0] = arr[0, 1] + arr[1, 1] <= w ? 1 : 2;
            dp[1, 1] = dp[1, 2] = 1;
            Solve(n, w, arr, dp);
            ans = Math.Min(ans, dp[n, 0]);

            if (arr[0, 1] + arr[0, n] <= w)
            {
                dp[1, 0] = 2;
                dp[1, 1] = dp[1, 2] = 1;
                arr[0, 1] = INF;
                Solve(n, w, arr, dp);
                ans = Math.Min(ans, dp[n, 1]);
                arr[0, 1] = t_up;
            }

            if (arr[1, 1] + arr[1, n] <= w)
            {
                dp[1, 0] = 2;
                dp[1, 1] = dp[1, 2] = 1;
                arr[1, 1] = INF;
                Solve(n, w, arr, dp);
                ans = Math.Min(ans, dp[n, 2]);
                arr[1, 1] = t_down;
            }

            if (arr[0, 1] + arr[0, n] <= w && arr[1, 1] + arr[1, n] <= w)
            {
                arr[0, 1] = arr[1, 1] = INF;
                dp[1, 0] = 2;
                dp[1, 1] = dp[1, 2] = 1;
                Solve(n, w, arr, dp);
                ans = Math.Min(ans, dp[n - 1, 0]);
                arr[0, 1] = t_up;
                arr[1, 1] = t_down;
            }

            if (n == 1)
                ans = arr[0, 1] + arr[1, 1] <= w ? 1 : 2;

            Console.WriteLine(ans);
        }
    }
}
