import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class _11650 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        Point[] points = new Point[N];
        
        for (int i = 0; i < N; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            points[i] = new Point(x, y);
        }
        
        scanner.close();
        
        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                if (p1.x == p2.x) {
                    return Integer.compare(p1.y, p2.y);
                }
                return Integer.compare(p1.x, p2.x);
            }
        });
        
        StringBuilder output = new StringBuilder();
        for (Point point : points) {
            output.append(point.x).append(" ").append(point.y).append("\n");
        }
        System.out.print(output.toString());
    }
}

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}