import java.io.*;
import java.util.*;

class Point implements Comparable<Point> {
    long x, y, p, q;

    Point(long x, long y) {
        this.x = x;
        this.y = y;
        this.p = 0;
        this.q = 0;
    }

    @Override
    public int compareTo(Point other) {
        if (this.x != other.x) {
            return Long.compare(this.x, other.x);
        }
        return Long.compare(this.y, other.y);
    }
}

public class _1708 {
    static int N;
    static Point[] points;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        points = new Point[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            points[i] = new Point(x, y);
        }

        convexHull();
    }

    static int ccw(Point p1, Point p2, Point p3) {
        long res = (p1.x * p2.y + p2.x * p3.y + p3.x * p1.y) - 
                   (p2.x * p1.y + p3.x * p2.y + p1.x * p3.y);
        if (res > 0) return 1;    // counter-clockwise
        else if (res < 0) return -1; // clockwise
        else return 0;             // collinear
    }

    static long det(Point p1, Point p2) {
        return p1.p * p2.q - p1.q * p2.p;
    }

    static Comparator<Point> angleComparator = new Comparator<Point>() {
        @Override
        public int compare(Point p1, Point p2) {
            long det = det(p1, p2);
            if (det > 0) {
                return -1;
            } else if (det < 0) {
                return 1;
            } else {
                long dist1 = p1.p * p1.p + p1.q * p1.q;
                long dist2 = p2.p * p2.p + p2.q * p2.q;
                return Long.compare(dist1, dist2);
            }
        }
    };

    static void convexHull() {
        Arrays.sort(points);

        for (int i = 1; i < N; i++) {
            points[i].p = points[i].x - points[0].x;
            points[i].q = points[i].y - points[0].y;
        }

        Arrays.sort(points, 1, N, angleComparator);

        List<Point> hull = new ArrayList<>();
        hull.add(points[0]);
        hull.add(points[1]);

        for (int i = 2; i < N; i++) {
            Point top = hull.remove(hull.size() - 1);
            while (!hull.isEmpty() && ccw(hull.get(hull.size() - 1), top, points[i]) <= 0) {
                top = hull.remove(hull.size() - 1);
            }
            hull.add(top);
            hull.add(points[i]);
        }

        System.out.println(hull.size());
    }
}
