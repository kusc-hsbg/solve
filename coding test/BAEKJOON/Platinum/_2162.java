import java.util.Scanner;

public class _2162 {
    static int[] parent, size;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] segments = new int[N][4];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 4; j++) {
                segments[i][j] = scanner.nextInt();
            }
        }
        
        scanner.close();

        parent = new int[N];
        size = new int[N];

        for (int i = 0; i < N; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (intersect(segments[i], segments[j])) {
                    union(i, j);
                }
            }
        }

        int numGroups = 0;
        int maxGroupSize = 0;
        for (int i = 0; i < N; i++) {
            if (find(i) == i) {
                numGroups++;
                maxGroupSize = Math.max(maxGroupSize, size[i]);
            }
        }

        System.out.println(numGroups);
        System.out.println(maxGroupSize);
    }

    static boolean intersect(int[] seg1, int[] seg2) {
        int x1 = seg1[0], y1 = seg1[1], x2 = seg1[2], y2 = seg1[3];
        int x3 = seg2[0], y3 = seg2[1], x4 = seg2[2], y4 = seg2[3];
        
        int d1 = direction(x3, y3, x4, y4, x1, y1);
        int d2 = direction(x3, y3, x4, y4, x2, y2);
        int d3 = direction(x1, y1, x2, y2, x3, y3);
        int d4 = direction(x1, y1, x2, y2, x4, y4);

        if (d1 != d2 && d3 != d4) return true;
        if (d1 == 0 && onSegment(x3, y3, x4, y4, x1, y1)) return true;
        if (d2 == 0 && onSegment(x3, y3, x4, y4, x2, y2)) return true;
        if (d3 == 0 && onSegment(x1, y1, x2, y2, x3, y3)) return true;
        if (d4 == 0 && onSegment(x1, y1, x2, y2, x4, y4)) return true;

        return false;
    }

    static int direction(int x1, int y1, int x2, int y2, int x3, int y3) {
        int val = (y2 - y1) * (x3 - x2) - (x2 - x1) * (y3 - y2);
        if (val == 0) return 0;
        return (val > 0) ? 1 : -1;
    }

    static boolean onSegment(int x1, int y1, int x2, int y2, int x, int y) {
        if (x <= Math.max(x1, x2) && x >= Math.min(x1, x2) && y <= Math.max(y1, y2) && y >= Math.min(y1, y2)) {
            return true;
        }
        return false;
    }

    static int find(int u) {
        if (parent[u] == u) return u;
        return parent[u] = find(parent[u]);
    }

    static void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);
        if (rootU != rootV) {
            parent[rootV] = rootU;
            size[rootU] += size[rootV];
        }
    }
}
