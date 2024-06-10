import java.util.Scanner;
import java.util.Stack;

public class _9012 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int T = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < T; i++) {
            String parenthesisString = scanner.nextLine();
            if (isValidParenthesisString(parenthesisString)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        
        scanner.close();
    }

    private static boolean isValidParenthesisString(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}