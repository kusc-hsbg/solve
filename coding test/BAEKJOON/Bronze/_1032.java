import java.util.Scanner;

public class _1032 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        
        String[] fileNames = new String[n];
        for (int i = 0; i < n; i++) {
            fileNames[i] = scanner.nextLine();
        }
        
        char[] pattern = fileNames[0].toCharArray();
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < pattern.length; j++) {
                if (pattern[j] != fileNames[i].charAt(j)) {
                    pattern[j] = '?';
                }
            }
        }
        
        System.out.println(new String(pattern));
        
        scanner.close();
    }
}
