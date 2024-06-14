// import java.util.*;
import java.io.*;

public class _18186 {
    static int N, B, C;
    static long totalCost = 0;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] line = bf.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        B = Integer.parseInt(line[1]);
        C = Integer.parseInt(line[2]);

        arr = new int[N];
        line = bf.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }

        if (B <= C) {
            for (int i = 0; i < N; i++) {
                totalCost += (long) arr[i] * B;
            }
            System.out.println(totalCost);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (i < N - 2 && arr[i + 1] > arr[i + 2]) {
                int buy2 = Math.min(arr[i], arr[i + 1] - arr[i + 2]);
                totalCost += (long) buy2 * (B + C);
                arr[i] -= buy2;
                arr[i + 1] -= buy2;
            }

            if (i < N - 2) {
                int buy3 = Math.min(arr[i], Math.min(arr[i + 1], arr[i + 2]));
                totalCost += (long) buy3 * (B + 2 * C);
                arr[i] -= buy3;
                arr[i + 1] -= buy3;
                arr[i + 2] -= buy3;
            }

            if (i < N - 1) {
                int buy2 = Math.min(arr[i], arr[i + 1]);
                totalCost += (long) buy2 * (B + C);
                arr[i] -= buy2;
                arr[i + 1] -= buy2;
            }

            totalCost += (long) arr[i] * B;
        }

        System.out.println(totalCost);
    }
}