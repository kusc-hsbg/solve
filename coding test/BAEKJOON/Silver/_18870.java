import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _18870 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int[] coords = new int[N];
        int[] sortedCoords = new int[N];
        
        for (int i = 0; i < N; i++) {
            coords[i] = scanner.nextInt();
            sortedCoords[i] = coords[i];
        }
        
        Arrays.sort(sortedCoords);
        Map<Integer, Integer> compressedMap = new HashMap<>();
        int rank = 0;
        
        for (int i = 0; i < N; i++) {
            if (!compressedMap.containsKey(sortedCoords[i])) {
                compressedMap.put(sortedCoords[i], rank);
                rank++;
            }
        }
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < N; i++) {
            result.append(compressedMap.get(coords[i])).append(" ");
        }
        System.out.println(result.toString().trim());
        scanner.close();
    }
}
