import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _1046 {
    static int count = 0;
    static int x = 0;
    static int y = 0;
    static double result = 0;
    static List<double[]> p = new ArrayList<>();
    static List<double[]> slopeList = new ArrayList<>();
    static int h, w;
    static char[][] box;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            h = sc.nextInt();
            w = sc.nextInt();
            sc.nextLine();
            box = new char[h][w];

            double[] Light = new double[2];

            for (int i = 0; i < h; i++) {
                String line = sc.nextLine();
                box[i] = line.toCharArray();
                for (int j = 0; j < w; j++) {
                    if (box[i][j] == '*') {
                        x = j;
                        y = i;
                        Light[0] = j + 0.5;
                        Light[1] = i + 0.5;
                    } else if (box[i][j] == '#') {
                        count++;
                    }
                }
            }

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    double[] slope = new double[2];
                    int xPos = w * j;
                    int yPos = h * i;
                    slope[0] = (xPos - Light[0] > 0) ? 1 : -1;
                    slope[1] = (yPos - Light[1]) / (xPos - Light[0]);
                    slopeList.add(slope);
                }
            }

            for (int i = 0; i < h + 1; i++) {
                for (int j = 0; j < w + 1; j++) {
                    double[] slope = new double[2];
                    slope[0] = (j - Light[0] > 0) ? 1 : -1;
                    slope[1] = (i - Light[1]) / (j - Light[0]);
                    boolean exists = false;
                    for (double[] s : slopeList) {
                        if (slope[0] == s[0] && slope[1] == s[1]) {
                            exists = true;
                            break;
                        }
                    }
                    if (!exists) {
                        slopeList.add(slope);
                    }
                }
            }

            slopeList.sort((a, b) -> {
                if (a[0] == b[0]) return Double.compare(a[1], b[1]);
                return Double.compare(a[0], b[0]);
            });

            for (double[] slope : slopeList) {
                search(x, y, Light.clone(), slope);
            }

            for (int i = 0; i < p.size(); i++) {
                int j = (i + 1) % p.size();
                result += Math.abs((Light[0] * p.get(i)[1] + p.get(i)[0] * p.get(j)[1] + p.get(j)[0] * Light[1]) - 
                                   (p.get(i)[0] * Light[1] + p.get(j)[0] * p.get(i)[1] + Light[0] * p.get(j)[1])) / 2;
            }

            System.out.printf("%.13f\n", w * h - result - count);
        } finally {
            sc.close();
        }
    }

    static void search(int x, int y, double[] pos, double[] angle) {
        if (x == -1 || x == w || y == -1 || y == h || box[y][x] == '#') {
            p.add(pos);
            return;
        }

        int x1 = (angle[0] > 0) ? x + 1 : x - 1;
        int x2 = (angle[0] > 0) ? x + 1 : x;
        int y1 = (angle[0] * angle[1] > 0) ? y + 1 : y - 1;
        int y2 = (angle[0] * angle[1] > 0) ? y + 1 : y;

        double y_nx = pos[1] + (angle[1]) * (x2 - pos[0]);
        double x_ny = pos[0] + ((y2 - pos[1]) / (angle[1]));

        if (y + 1e-7 < y_nx && y_nx < y + 1 - 1e-7 && (x_ny < x - 1e-7 || x_ny > x + 1 + 1e-7)) {
            pos = new double[]{x2, y_nx};
            search(x1, y, pos, angle);
        } else if (x + 1e-7 < x_ny && x_ny < x + 1 - 1e-7 && (y - 1e-7 > y_nx || y_nx > y + 1 + 1e-7)) {
            pos = new double[]{x_ny, y2};
            search(x, y1, pos, angle);
        } else {
            pos = new double[]{x2, y2};
            if (angle[1] > 0 && (x1 == -1 || x1 == w || box[y][x1] == '#')) {
                p.add(pos);
            }
            if (angle[1] < 0 && (y1 == -1 || y1 == h || box[y1][x] == '#')) {
                p.add(pos);
            }
            search(x1, y1, pos, angle);
            if (angle[1] > 0 && (y1 == -1 || y1 == h || box[y1][x] == '#')) {
                p.add(pos);
            }
            if (angle[1] < 0 && (x1 == -1 || x1 == w || box[y][x1] == '#')) {
                p.add(pos);
            }
        }
    }
}
