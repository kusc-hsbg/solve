import java.util.Scanner;

public class _1027 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] buildings = new int[N];
        for (int i = 0; i < N; i++) {
            buildings[i] = scanner.nextInt();
        }
        scanner.close();

        int result = 0;
        for (int i1 = 0; i1 < N; i1++) {
            int x1 = i1 + 1;
            int y1 = buildings[i1];

            Double curSlopeRight = null;
            int visibleRight = 0;
            for (int i2 = i1 + 1; i2 < N; i2++) {
                int x2 = i2 + 1;
                int y2 = buildings[i2];
                double slopeRight = slope(x1, y1, x2, y2);
                if (curSlopeRight == null || curSlopeRight < slopeRight) {
                    curSlopeRight = slopeRight;
                    visibleRight++;
                }
            }

            Double curSlopeLeft = null;
            int visibleLeft = 0;
            for (int i3 = i1 - 1; i3 >= 0; i3--) {
                int x2 = i3 + 1;
                int y2 = buildings[i3];
                double slopeLeft = slope(x1, y1, x2, y2);
                if (curSlopeLeft == null || curSlopeLeft > slopeLeft) {
                    curSlopeLeft = slopeLeft;
                    visibleLeft++;
                }
            }

            result = Math.max(result, visibleLeft + visibleRight);
        }

        System.out.println(result);
    }

    private static double slope(int x1, int y1, int x2, int y2) {
        return (double) (y2 - y1) / (x2 - x1);
    }
}