import java.util.Scanner;

public class _7568 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int[][] people = new int[N][2];
        
        for (int i = 0; i < N; i++) {
            people[i][0] = scanner.nextInt();
            people[i][1] = scanner.nextInt(); 
        }
        
        scanner.close();
        
        int[] ranks = new int[N];
        
        for (int i = 0; i < N; i++) {
            int rank = 1;
            for (int j = 0; j < N; j++) {
                if (i != j && people[j][0] > people[i][0] && people[j][1] > people[i][1]) {
                    rank++;
                }
            }
            ranks[i] = rank;
        }
        
        for (int i = 0; i < N; i++) {
            System.out.print(ranks[i] + " ");
        }
    }
}