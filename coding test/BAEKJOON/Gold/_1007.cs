using System;
using System.Collections.Generic;
using System.Linq;

class Program
{
    static void Main()
    {
        int T = int.Parse(Console.ReadLine() ?? "0");
        var results = new List<double>();

        for (int t = 0; t < T; t++)
        {
            int N = int.Parse(Console.ReadLine() ?? "0");
            var coords = new List<(int x, int y)>();

            int xTotal = 0;
            int yTotal = 0;
            for (int i = 0; i < N; i++)
            {
                var input = Console.ReadLine()?.Split().Select(int.Parse).ToArray();
                if (input == null || input.Length < 2) continue;
                int x = input[0];
                int y = input[1];
                xTotal += x;
                yTotal += y;
                coords.Add((x, y));
            }

            double res = double.MaxValue;
            var combination = new bool[N];
            FindMinVectorSum(coords, combination, 0, 0, 0, 0, xTotal, yTotal, N / 2, ref res);

            results.Add(res);
        }

        foreach (var result in results)
        {
            Console.WriteLine($"{result:F9}");
        }
    }

    static void FindMinVectorSum(List<(int x, int y)> coords, bool[] combination, int start, int depth, int x1Total, int y1Total, int xTotal, int yTotal, int targetDepth, ref double res)
    {
        if (depth == targetDepth)
        {
            int x2Total = xTotal - x1Total;
            int y2Total = yTotal - y1Total;
            double vectorSum = Math.Sqrt(Math.Pow(x1Total - x2Total, 2) + Math.Pow(y1Total - y2Total, 2));
            res = Math.Min(res, vectorSum);
            return;
        }

        for (int i = start; i < coords.Count; i++)
        {
            if (!combination[i])
            {
                combination[i] = true;
                FindMinVectorSum(coords, combination, i + 1, depth + 1, x1Total + coords[i].x, y1Total + coords[i].y, xTotal, yTotal, targetDepth, ref res);
                combination[i] = false;
            }
        }
    }
}
