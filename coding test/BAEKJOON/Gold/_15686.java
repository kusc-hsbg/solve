import java.util.*;
import java.io.*;

public class _15686 {
    static int N, M;
    static List<int[]> homes = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    static int minDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 1) {
                    homes.add(new int[] {i, j});
                } else if (value == 2) {
                    chickens.add(new int[] {i, j});
                }
            }
        }

        combination(new int[M], 0, 0);
        System.out.println(minDistance);
    }

    private static void combination(int[] selected, int start, int depth) {
        if (depth == M) {
            minDistance = Math.min(minDistance, getCityChickenDistance(selected));
            return;
        }
        
        for (int i = start; i < chickens.size(); i++) {
            selected[depth] = i;
            combination(selected, i + 1, depth + 1);
        }
    }

    private static int getCityChickenDistance(int[] selected) {
        int totalDistance = 0;
        
        for (int[] home : homes) {
            int homeX = home[0];
            int homeY = home[1];
            int minHomeDistance = Integer.MAX_VALUE;
            
            for (int index : selected) {
                int[] chicken = chickens.get(index);
                int chickenX = chicken[0];
                int chickenY = chicken[1];
                int distance = Math.abs(homeX - chickenX) + Math.abs(homeY - chickenY);
                minHomeDistance = Math.min(minHomeDistance, distance);
            }
            
            totalDistance += minHomeDistance;
        }
        
        return totalDistance;
    }
}
