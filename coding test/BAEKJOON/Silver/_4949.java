import java.util.Scanner;
import java.util.Stack;

public class _4949 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String line = scanner.nextLine();
            if (line.equals(".")) {
                break;
            }

            if (isBalanced(line)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
        
        scanner.close();
    }

    private static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                }
                stack.pop();
            } else if (ch == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
