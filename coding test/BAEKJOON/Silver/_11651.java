import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[][] points = new int[N][2];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] point1, int[] point2) {
                if (point1[1] == point2[1]) {
                    return Integer.compare(point1[0], point2[0]);
                } else {
                    return Integer.compare(point1[1], point2[1]);
                }
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for (int[] point : points) {
            sb.append(point[0]).append(" ").append(point[1]).append("\n");
        }
        
        System.out.print(sb.toString());
    }
}