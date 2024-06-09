import java.util.Scanner;

public class _1117 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long w = scanner.nextLong();
        long h = scanner.nextLong();
        long f = scanner.nextLong();
        long c = scanner.nextLong();
        long x1 = scanner.nextLong();
        long y1 = scanner.nextLong();
        long x2 = scanner.nextLong();
        long y2 = scanner.nextLong();
        
        long area = (x2 - x1) * (y2 - y1) * (c + 1);
        long remainingArea;

        if (f <= w / 2) {
            if (f <= x1) {
                remainingArea = w * h - area;
            } else {
                remainingArea = w * h - (area + (Math.min(f, x2) - x1) * (y2 - y1) * (c + 1));
            }
        } else {
            if (w <= x1 + f) {
                remainingArea = w * h - area;
            } else {
                remainingArea = w * h - (area + (Math.min(w, f + x2) - (f + x1)) * (y2 - y1) * (c + 1));
            }
        }

        System.out.println(remainingArea);
        scanner.close();
    }
}
