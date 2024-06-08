using System;
using System.Collections.Generic;

class Program
{
    static void Main()
    {
        List<int> testCases = new List<int>();
        int maxLimit = 123456 * 2;

        while (true)
        {
            string input = Console.ReadLine();
            if (input == null || !int.TryParse(input, out int n) || n == 0) 
                break;
            testCases.Add(n);
        }

        bool[] isPrime = new bool[maxLimit + 1];
        for (int i = 2; i <= maxLimit; i++)
        {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= maxLimit; i++)
        {
            if (isPrime[i])
            {
                for (int j = i * i; j <= maxLimit; j += i)
                {
                    isPrime[j] = false;
                }
            }
        }

        foreach (int n in testCases)
        {
            int count = 0;
            for (int i = n + 1; i <= 2 * n; i++)
            {
                if (isPrime[i])
                {
                    count++;
                }
            }
            Console.WriteLine(count);
        }
    }
}