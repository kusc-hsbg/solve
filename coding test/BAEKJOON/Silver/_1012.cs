using System;
using System.Collections.Generic;

class Program
{
    static void Main()
    {
        if (!int.TryParse(Console.ReadLine(), out int T))
        {
            return;
        }

        for (int t = 0; t < T; t++)
        {
            var line = Console.ReadLine()?.Split();
            if (line == null || line.Length < 3)
            {
                continue;
            }

            if (!int.TryParse(line[0], out int M) || !int.TryParse(line[1], out int N) || !int.TryParse(line[2], out int K))
            {
                continue;
            }

            int[,] field = new int[M, N];
            for (int i = 0; i < K; i++)
            {
                var position = Console.ReadLine()?.Split();
                if (position == null || position.Length < 2)
                {
                    continue;
                }

                if (!int.TryParse(position[0], out int x) || !int.TryParse(position[1], out int y))
                {
                    continue;
                }

                field[x, y] = 1;
            }

            bool[,] visited = new bool[M, N];
            int wormCount = 0;

            for (int i = 0; i < M; i++)
            {
                for (int j = 0; j < N; j++)
                {
                    if (field[i, j] == 1 && !visited[i, j])
                    {
                        BFS(field, visited, i, j, M, N);
                        wormCount++;
                    }
                }
            }

            Console.WriteLine(wormCount);
        }
    }

    static void BFS(int[,] field, bool[,] visited, int startX, int startY, int M, int N)
    {
        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };

        Queue<(int x, int y)> queue = new Queue<(int x, int y)>();
        queue.Enqueue((startX, startY));
        visited[startX, startY] = true;

        while (queue.Count > 0)
        {
            var (x, y) = queue.Dequeue();

            for (int i = 0; i < 4; i++)
            {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N && field[nx, ny] == 1 && !visited[nx, ny])
                {
                    queue.Enqueue((nx, ny));
                    visited[nx, ny] = true;
                }
            }
        }
    }
}
