import java.io.*;
import java.util.StringTokenizer;

public class _2357 {
    static int[] arr;
    static int[] segTreeMin;
    static int[] segTreeMax;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        arr = new int[N];
        segTreeMin = new int[4 * N];
        segTreeMax = new int[4 * N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }

        buildMinTree(0, N - 1, 1);
        buildMaxTree(0, N - 1, 1);

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int left = Integer.parseInt(tokenizer.nextToken()) - 1;
            int right = Integer.parseInt(tokenizer.nextToken()) - 1;

            int minVal = queryMin(0, N - 1, left, right, 1);
            int maxVal = queryMax(0, N - 1, left, right, 1);

            output.append(minVal).append(" ").append(maxVal).append("\n");
        }

        writer.write(output.toString());
        writer.flush();
        writer.close();
        reader.close();
    }

    static void buildMinTree(int start, int end, int node) {
        if (start == end) {
            segTreeMin[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            buildMinTree(start, mid, 2 * node);
            buildMinTree(mid + 1, end, 2 * node + 1);
            segTreeMin[node] = Math.min(segTreeMin[2 * node], segTreeMin[2 * node + 1]);
        }
    }

    static void buildMaxTree(int start, int end, int node) {
        if (start == end) {
            segTreeMax[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            buildMaxTree(start, mid, 2 * node);
            buildMaxTree(mid + 1, end, 2 * node + 1);
            segTreeMax[node] = Math.max(segTreeMax[2 * node], segTreeMax[2 * node + 1]);
        }
    }

    static int queryMin(int start, int end, int left, int right, int node) {
        if (right < start || left > end) {
            return Integer.MAX_VALUE;
        }
        if (left <= start && end <= right) {
            return segTreeMin[node];
        }
        int mid = (start + end) / 2;
        int leftMin = queryMin(start, mid, left, right, 2 * node);
        int rightMin = queryMin(mid + 1, end, left, right, 2 * node + 1);
        return Math.min(leftMin, rightMin);
    }

    static int queryMax(int start, int end, int left, int right, int node) {
        if (right < start || left > end) {
            return Integer.MIN_VALUE;
        }
        if (left <= start && end <= right) {
            return segTreeMax[node];
        }
        int mid = (start + end) / 2;
        int leftMax = queryMax(start, mid, left, right, 2 * node);
        int rightMax = queryMax(mid + 1, end, left, right, 2 * node + 1);
        return Math.max(leftMax, rightMax);
    }
}
