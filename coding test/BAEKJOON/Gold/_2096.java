import java.io.*;
import java.util.*;

public class _2096 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int[][] minArr = new int[2][3];
        int[][] maxArr = new int[2][3];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (i == 0) {
                    minArr[0][j] = value;
                    maxArr[0][j] = value;
                } else {
                    minArr[1][j] = value;
                    maxArr[1][j] = value;
                }
            }
            if (i > 0) {
                updateArrays(minArr, maxArr);
            }
        }

        int maxResult = Math.max(maxArr[0][0], Math.max(maxArr[0][1], maxArr[0][2]));
        int minResult = Math.min(minArr[0][0], Math.min(minArr[0][1], minArr[0][2]));

        bw.write(maxResult + " " + minResult);
        bw.flush();
        bw.close();
    }

    private static void updateArrays(int[][] minArr, int[][] maxArr) {
        maxArr[1][0] += Math.max(maxArr[0][0], maxArr[0][1]);
        maxArr[1][1] += Math.max(maxArr[0][0], Math.max(maxArr[0][1], maxArr[0][2]));
        maxArr[1][2] += Math.max(maxArr[0][1], maxArr[0][2]);
        minArr[1][0] += Math.min(minArr[0][0], minArr[0][1]);
        minArr[1][1] += Math.min(minArr[0][0], Math.min(minArr[0][1], minArr[0][2]));
        minArr[1][2] += Math.min(minArr[0][1], minArr[0][2]);

        for (int j = 0; j < 3; j++) {
            minArr[0][j] = minArr[1][j];
            maxArr[0][j] = maxArr[1][j];
        }
    }
}
