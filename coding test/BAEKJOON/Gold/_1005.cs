using System;
using System.Collections.Generic;
using System.Linq;

class Program
{
    static void Main()
    {
        int T = int.Parse(Console.ReadLine());
        for (int t = 0; t < T; t++)
        {
            var firstLine = Console.ReadLine().Split().Select(int.Parse).ToArray();
            int N = firstLine[0];
            int K = firstLine[1];

            var buildTimes = Console.ReadLine().Split().Select(int.Parse).ToArray();
            var dependencies = new List<int>[N + 1];
            for (int i = 1; i <= N; i++)
            {
                dependencies[i] = new List<int>();
            }
            
            int[] inDegrees = new int[N + 1];
            for (int i = 0; i < K; i++)
            {
                var dependency = Console.ReadLine().Split().Select(int.Parse).ToArray();
                int X = dependency[0];
                int Y = dependency[1];
                dependencies[X].Add(Y);
                inDegrees[Y]++;
            }

            int W = int.Parse(Console.ReadLine());

            Queue<int> queue = new Queue<int>();
            int[] dp = new int[N + 1];
            for (int i = 1; i <= N; i++)
            {
                dp[i] = buildTimes[i - 1];
                if (inDegrees[i] == 0)
                {
                    queue.Enqueue(i);
                }
            }

            while (queue.Count > 0)
            {
                int current = queue.Dequeue();
                foreach (int next in dependencies[current])
                {
                    dp[next] = Math.Max(dp[next], dp[current] + buildTimes[next - 1]);
                    if (--inDegrees[next] == 0)
                    {
                        queue.Enqueue(next);
                    }
                }
            }

            Console.WriteLine(dp[W]);
        }
    }
}