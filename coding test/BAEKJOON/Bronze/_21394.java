import java.util.Scanner;
// import java.util.StringJoiner;

public class _21394 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        
        for (int cnt = 0; cnt < N; cnt++) {
            int[] cardCnt = new int[10];
            String[] input = scanner.nextLine().split(" ");
            
            for (int i = 0; i < 9; i++) {
                cardCnt[i + 1] = Integer.parseInt(input[i]);
            }
            
            cardCnt[9] += cardCnt[6];
            cardCnt[6] = 0;
            
            StringBuilder sbLeft = new StringBuilder();
            StringBuilder sbRight = new StringBuilder();
            
            for (int i = 9; i >= 1; i--) {
                while (cardCnt[i]-- > 0) {
                    if (sbLeft.length() <= sbRight.length()) {
                        sbLeft.append(i).append(" ");
                    } else {
                        sbRight.insert(0, i + " ");
                    }
                }
            }
            
            System.out.println(sbLeft.toString() + sbRight.toString().trim());
        }
        
        scanner.close();
    }
}
