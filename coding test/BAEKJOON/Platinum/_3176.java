import java.io.*;
import java.util.*;

public class _3176 {
    static int[] fenwickTree;
    static int[] position;
    static int[] dvdPosition;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        StringBuilder result = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            fenwickTree = new int[n + m + 1];
            position = new int[n + 1];
            dvdPosition = new int[m];

            st = new StringTokenizer(reader.readLine());
            for (int i = 0; i < m; i++) {
                dvdPosition[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                position[i] = m + i;
                updateFenwickTree(m + i, 1);
            }

            int currentTop = m;
            for (int i = 0; i < m; i++) {
                int dvd = dvdPosition[i];
                int pos = position[dvd];

                int aboveCount = queryFenwickTree(pos) - 1;
                result.append(aboveCount).append(" ");
                updateFenwickTree(pos, -1);
                position[dvd] = currentTop;
                updateFenwickTree(currentTop, 1);

                currentTop--;
            }
            result.append("\n");
        }
        System.out.print(result);
    }

    static void updateFenwickTree(int index, int value) {
        while (index <= n + m) {
            fenwickTree[index] += value;
            index += index & -index;
        }
    }

    static int queryFenwickTree(int index) {
        int sum = 0;
        while (index > 0) {
            sum += fenwickTree[index];
            index -= index & -index;
        }
        return sum;
    }
}