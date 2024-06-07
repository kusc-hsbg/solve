using System;
using System.Collections.Generic;

class Program
{
    struct Mat
    {
        public int val;
        public List<int> edge;
    }

    static int vis = 0;
    static Mat[] arr;

    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        arr = new Mat[n];
        for (int i = 0; i < n; i++)
        {
            arr[i] = new Mat { val = 1, edge = new List<int>() };
        }

        for (int i = 0; i < n - 1; i++)
        {
            string[] input = Console.ReadLine().Split();
            int a = int.Parse(input[0]);
            int b = int.Parse(input[1]);
            int p = int.Parse(input[2]);
            int q = int.Parse(input[3]);

            int gcdVal = GCD(p, q);
            int amod = arr[b].val * p / gcdVal;
            int bmod = arr[a].val * q / gcdVal;
            gcdVal = GCD(amod, bmod);
            vis = 0;
            Update(a, amod / gcdVal);
            Update(b, bmod / gcdVal);
            arr[a].edge.Add(b);
            arr[b].edge.Add(a);
        }

        for (int i = 0; i < n; i++)
            Console.Write(arr[i].val + " ");
    }

    static int GCD(int a, int b)
    {
        return b == 0 ? a : GCD(b, a % b);
    }

    static void Update(int node, int mod)
    {
        arr[node].val *= mod;
        vis |= (1 << node);
        foreach (var e in arr[node].edge)
        {
            if ((vis & (1 << e)) == 0)
            {
                Update(e, mod);
            }
        }
    }
}
