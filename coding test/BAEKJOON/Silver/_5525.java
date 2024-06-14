import java.util.Scanner;

public class _5525 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine();
        String S = scanner.nextLine();
        
        int result = countPNOccurrences(N, M, S);
        System.out.println(result);
        scanner.close();
    }
    
    public static int countPNOccurrences(int N, int M, String S) {
        int count = 0;
        int i = 0;

        while (i < M - 2) {
            if (S.charAt(i) == 'I' && S.charAt(i + 1) == 'O' && S.charAt(i + 2) == 'I') {
                int length = 0;
                while (i + 2 < M && S.charAt(i) == 'I' && S.charAt(i + 1) == 'O' && S.charAt(i + 2) == 'I') {
                    length++;
                    i += 2;
                }
                if (length >= N) {
                    count += length - N + 1;
                }
                i -= 1;
            }
            i++;
        }

        return count;
    }
}