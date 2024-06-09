import java.util.Scanner;

public class _1041 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[] dice = new int[6];
        
        for (int i = 0; i < 6; i++) {
            dice[i] = scanner.nextInt();
        }

        // 스캐너 닫기
        scanner.close();

        if (n == 1) {
            int sum = 0;
            int maxFace = 0;
            for (int face : dice) {
                sum += face;
                if (face > maxFace) {
                    maxFace = face;
                }
            }
            System.out.println(sum - maxFace);
            return;
        }

        int[] min = new int[3];
        min[0] = Integer.MAX_VALUE;
        min[1] = Integer.MAX_VALUE;
        min[2] = Integer.MAX_VALUE;

        for (int face : dice) {
            if (face < min[0]) {
                min[0] = face;
            }
        }

        int[][] twoFaceCombos = {
            {0, 1}, {0, 2}, {0, 3}, {0, 4},
            {1, 2}, {1, 3}, {1, 5},
            {2, 4}, {2, 5},
            {3, 4}, {3, 5},
            {4, 5}
        };
        for (int[] combo : twoFaceCombos) {
            int sum = dice[combo[0]] + dice[combo[1]];
            if (sum < min[1]) {
                min[1] = sum;
            }
        }

        int[][] threeFaceCombos = {
            {0, 1, 2}, {0, 1, 3}, {0, 2, 4}, {0, 3, 4},
            {1, 2, 5}, {1, 3, 5},
            {2, 4, 5}, {3, 4, 5}
        };
        for (int[] combo : threeFaceCombos) {
            int sum = dice[combo[0]] + dice[combo[1]] + dice[combo[2]];
            if (sum < min[2]) {
                min[2] = sum;
            }
        }

        long total = 0;
        long n2 = (long) n * n;

        total += (5 * n2 - 16 * n + 12) * min[0];
        total += (8 * n - 12) * min[1]; 
        total += 4 * min[2];

        System.out.println(total);
    }
}
