import java.util.Scanner;

public class _2292 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long N = scanner.nextLong();
        scanner.close();
        
        System.out.println(findMinSteps(N));
    }
    
    private static int findMinSteps(long N) {
        if (N == 1) {
            return 1;
        }
        
        int layer = 1;
        long maxNumInLayer = 1;
        
        while (maxNumInLayer < N) {
            maxNumInLayer += 6 * layer;
            layer++;
        }
        
        return layer;
    }
}
