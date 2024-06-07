import java.util.*;

public class _1077 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        
        List<Point> poly1 = new ArrayList<>();
        List<Point> poly2 = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            poly1.add(new Point(scanner.nextInt(), scanner.nextInt()));
        }
        
        for (int i = 0; i < m; i++) {
            poly2.add(new Point(scanner.nextInt(), scanner.nextInt()));
        }
        
        double intersectArea = polygonIntersectionArea(poly1, poly2);
        System.out.printf("%.9f%n", intersectArea);
        
        scanner.close();
    }

    public static class Point {
        double x, y;
        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static double polygonIntersectionArea(List<Point> poly1, List<Point> poly2) {
        List<Point> intersection = new ArrayList<>();
        
        // Add vertices of poly1 that are inside poly2
        for (Point p : poly1) {
            if (isPointInPolygon(p, poly2)) {
                intersection.add(p);
            }
        }
        
        // Add vertices of poly2 that are inside poly1
        for (Point p : poly2) {
            if (isPointInPolygon(p, poly1)) {
                intersection.add(p);
            }
        }
        
        // Add intersection points of the edges of the polygons
        for (Point[] edge1 : getEdges(poly1)) {
            for (Point[] edge2 : getEdges(poly2)) {
                Point intersectionPoint = getIntersection(edge1[0], edge1[1], edge2[0], edge2[1]);
                if (intersectionPoint != null) {
                    intersection.add(intersectionPoint);
                }
            }
        }
        
        if (intersection.isEmpty()) {
            return 0.0;
        }
        
        List<Point> hull = convexHull(intersection);
        return polygonArea(hull);
    }

    public static List<Point[]> getEdges(List<Point> polygon) {
        List<Point[]> edges = new ArrayList<>();
        for (int i = 0; i < polygon.size(); i++) {
            Point start = polygon.get(i);
            Point end = polygon.get((i + 1) % polygon.size());
            edges.add(new Point[]{start, end});
        }
        return edges;
    }

    public static Point getIntersection(Point a1, Point a2, Point b1, Point b2) {
        double d = (a2.x - a1.x) * (b2.y - b1.y) - (a2.y - a1.y) * (b2.x - b1.x);
        if (d == 0) return null;
        
        double u = ((b1.x - a1.x) * (b2.y - b1.y) - (b1.y - a1.y) * (b2.x - b1.x)) / d;
        double v = ((b1.x - a1.x) * (a2.y - a1.y) - (b1.y - a1.y) * (a2.x - a1.x)) / d;
        
        if (u < 0 || u > 1 || v < 0 || v > 1) return null;
        
        return new Point(a1.x + u * (a2.x - a1.x), a1.y + u * (a2.y - a1.y));
    }

    public static List<Point> convexHull(List<Point> points) {
        points.sort(Comparator.comparing((Point p) -> p.x).thenComparing(p -> p.y));
        List<Point> hull = new ArrayList<>();
        
        for (Point p : points) {
            while (hull.size() >= 2 && crossProduct(hull.get(hull.size() - 2), hull.get(hull.size() - 1), p) <= 0) {
                hull.remove(hull.size() - 1);
            }
            hull.add(p);
        }
        
        int t = hull.size() + 1;
        for (int i = points.size() - 1; i >= 0; i--) {
            Point p = points.get(i);
            while (hull.size() >= t && crossProduct(hull.get(hull.size() - 2), hull.get(hull.size() - 1), p) <= 0) {
                hull.remove(hull.size() - 1);
            }
            hull.add(p);
        }
        
        hull.remove(hull.size() - 1);
        return hull;
    }

    public static double crossProduct(Point a, Point b, Point c) {
        return (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
    }

    public static boolean isPointInPolygon(Point p, List<Point> polygon) {
        int crossings = 0;
        for (int i = 0; i < polygon.size(); i++) {
            Point a = polygon.get(i);
            Point b = polygon.get((i + 1) % polygon.size());
            if ((a.y > p.y) != (b.y > p.y)) {
                double t = (p.y - a.y) / (b.y - a.y);
                if (p.x < a.x + t * (b.x - a.x)) {
                    crossings++;
                }
            }
        }
        return crossings % 2 == 1;
    }

    public static double polygonArea(List<Point> polygon) {
        double area = 0;
        for (int i = 0; i < polygon.size(); i++) {
            Point a = polygon.get(i);
            Point b = polygon.get((i + 1) % polygon.size());
            area += a.x * b.y - a.y * b.x;
        }
        return Math.abs(area) / 2.0;
    }
}
