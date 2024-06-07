using System;
using System.Collections.Generic;

class Program
{
    // Offsets for checking adjacent positions
    static readonly int[] col = { -1, 0, 1, -1, 0, 1 };
    static readonly int[] row = { -1, -1, -1, 1, 1, 1 };

    static int A, B;
    static List<int>[] adj = new List<int>[50];
    static int[] Bmatch = new int[50];
    static bool[] visited = new bool[50];

    static bool DFS(int a)
    {
        if (visited[a]) return false;
        visited[a] = true;
        foreach (int b in adj[a])
        {
            if (Bmatch[b] == -1 || DFS(Bmatch[b]))
            {
                Bmatch[b] = a;
                return true;
            }
        }
        return false;
    }

    static void Main()
    {
        if (!int.TryParse(Console.ReadLine(), out int T))
        {
            return;
        }

        for (int t = 0; t < T; t++)
        {
            var dimensions = Console.ReadLine()?.Split();
            if (dimensions == null || dimensions.Length < 2)
            {
                continue;
            }

            if (!int.TryParse(dimensions[0], out int N) || !int.TryParse(dimensions[1], out int M))
            {
                continue;
            }

            bool[,] map = new bool[10, 10];
            int broken = 0;

            for (int i = 0; i < N; i++)
            {
                var line = Console.ReadLine();
                if (line == null)
                {
                    continue;
                }

                for (int j = 0; j < M; j++)
                {
                    if (line[j] == 'x')
                    {
                        map[i, j] = true;
                        broken++;
                    }
                    else
                    {
                        map[i, j] = false;
                    }
                }
            }

            int[,] nodeNum = new int[10, 10];
            A = B = 0;
            for (int i = 0; i < N; i++)
                for (int j = 0; j < M; j += 2)
                {
                    adj[A] = new List<int>();
                    nodeNum[i, j] = A++;
                }
            for (int i = 0; i < N; i++)
                for (int j = 1; j < M; j += 2)
                    nodeNum[i, j] = B++;

            for (int j = 0; j < M; j += 2)
            {
                for (int i = 0; i < N; i++)
                {
                    if (map[i, j]) continue;
                    for (int d = 0; d < 6; d++)
                    {
                        int ni = i + col[d];
                        int nj = j + row[d];
                        if (ni < 0 || ni >= N || nj < 0 || nj >= M || map[ni, nj]) continue;
                        adj[nodeNum[i, j]].Add(nodeNum[ni, nj]);
                    }
                }
            }

            int cnt = 0;
            Array.Fill(Bmatch, -1);
            for (int i = 0; i < A; i++)
            {
                Array.Clear(visited, 0, visited.Length);
                if (DFS(i)) cnt++;
            }

            Console.WriteLine(N * M - broken - cnt);
        }
    }
}
