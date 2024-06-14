import java.util.*;

public class _1211 {
    static final int maxDigit = 18;
    static final int[][] expoDict = {
        {0, 0, 0, 0}, // 0
        {0, 0, 0, 0}, // 1
        {1, 0, 0, 0}, // 2
        {0, 1, 0, 0}, // 3
        {2, 0, 0, 0}, // 4
        {0, 0, 1, 0}, // 5
        {1, 1, 0, 0}, // 6
        {0, 0, 0, 1}, // 7
        {3, 0, 0, 0}, // 8
        {0, 2, 0, 0}  // 9
    };
    
    static int[] pMax = new int[4];
    static int[] p = {2, 3, 5, 7};
    static int[][][][][] saved;
    static int[] primeRemain = new int[4];

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            pMax[i] = 1;
            while (Math.pow(p[i], pMax[i]) < Math.pow(10, (maxDigit + 1) / 2.0)) {
                pMax[i]++;
            }
        }

        saved = new int[maxDigit][pMax[0]][pMax[1]][pMax[2]][pMax[3]];
        for (int i = 0; i < maxDigit; i++) {
            for (int j = 0; j < pMax[0]; j++) {
                for (int k = 0; k < pMax[1]; k++) {
                    for (int l = 0; l < pMax[2]; l++) {
                        Arrays.fill(saved[i][j][k][l], -1);
                    }
                }
            }
        }

        Scanner sc = new Scanner(System.in);
        try {
            long a = sc.nextLong();
            long b = sc.nextLong();

            long totalCount = 0;
            for (int p2 = 0; p2 <= pMax[0]; p2++) {
                if (Math.pow(2, p2) > Math.pow(10, maxDigit / 2.0)) break;
                for (int p3 = 0; p3 <= pMax[1]; p3++) {
                    if (Math.pow(2, p2) * Math.pow(3, p3) > Math.pow(10, maxDigit / 2.0)) break;
                    for (int p5 = 0; p5 <= pMax[2]; p5++) {
                        if (Math.pow(2, p2) * Math.pow(3, p3) * Math.pow(5, p5) > Math.pow(10, maxDigit / 2.0)) break;
                        for (int p7 = 0; p7 <= pMax[3]; p7++) {
                            if (Math.pow(2, p2) * Math.pow(3, p3) * Math.pow(5, p5) * Math.pow(7, p7) > Math.pow(10, maxDigit / 2.0)) break;
                            long dpNum = (long) (Math.pow(2, p2) * Math.pow(3, p3) * Math.pow(5, p5) * Math.pow(7, p7));
                            primeRemain[0] = p2;
                            primeRemain[1] = p3;
                            primeRemain[2] = p5;
                            primeRemain[3] = p7;
                            totalCount += getCount(0, 0, (long) Math.pow(10, maxDigit), (a + dpNum - 1) / dpNum, b / dpNum);
                        }
                    }
                }
            }

            System.out.println(totalCount);
        } finally {
            sc.close();
        }
    }

    static long getCount(int digit, long rangeStart, long rangeSize, long low, long high) {
        long rangeEnd = rangeStart + rangeSize - 1;
        if (high < low) return 0;
        if (high < rangeStart || rangeEnd < low) return 0;

        if (digit == 18) {
            for (int i = 0; i < 4; i++) {
                if (primeRemain[i] != 0) return 0;
            }
            return 1;
        }

        if (low <= rangeStart && rangeEnd <= high) {
            if (saved[digit][primeRemain[0]][primeRemain[1]][primeRemain[2]][primeRemain[3]] >= 0) {
                return saved[digit][primeRemain[0]][primeRemain[1]][primeRemain[2]][primeRemain[3]];
            }
        }

        long count = 0;
        rangeSize /= 10;
        for (int nextDigit = 0; nextDigit < 10; nextDigit++) {
            if (rangeStart > 0 && nextDigit == 0) continue;

            boolean isInsertable = true;
            for (int i = 0; i < 4; i++) {
                if (expoDict[nextDigit][i] > primeRemain[i]) {
                    isInsertable = false;
                    break;
                }
            }
            if (!isInsertable) continue;

            for (int i = 0; i < 4; i++) {
                primeRemain[i] -= expoDict[nextDigit][i];
            }

            count += getCount(digit + 1, rangeStart + nextDigit * rangeSize, rangeSize, low, high);

            for (int i = 0; i < 4; i++) {
                primeRemain[i] += expoDict[nextDigit][i];
            }
        }

        if (low <= rangeStart && rangeEnd <= high) {
            saved[digit][primeRemain[0]][primeRemain[1]][primeRemain[2]][primeRemain[3]] = (int) count;
        }

        return count;
    }
}
