import java.util.Scanner;

public class _1025 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            scanner.nextLine();

            char[][] grid = new char[N][M];
            for (int i = 0; i < N; i++) {
                String line = scanner.nextLine();
                for (int j = 0; j < M; j++) {
                    grid[i][j] = line.charAt(j);
                }
            }

            long maxSquare = -1;

            for (int rStart = 0; rStart < N; rStart++) {
                for (int cStart = 0; cStart < M; cStart++) {
                    for (int rStep = -N; rStep < N; rStep++) {
                        for (int cStep = -M; cStep < M; cStep++) {
                            if (rStep == 0 && cStep == 0) continue;

                            StringBuilder numberBuilder = new StringBuilder();
                            int r = rStart, c = cStart;
                            while (r >= 0 && r < N && c >= 0 && c < M) {
                                numberBuilder.append(grid[r][c]);
                                r += rStep;
                                c += cStep;
                            }

                            for (int len = 1; len <= numberBuilder.length(); len++) {
                                long number = Long.parseLong(numberBuilder.substring(0, len));
                                long sqrt = (long) Math.sqrt(number);
                                if (sqrt * sqrt == number) {
                                    maxSquare = Math.max(maxSquare, number);
                                }
                            }
                        }
                    }
                }
            }

            System.out.println(maxSquare);
        }
    }
}
