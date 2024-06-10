import java.util.Scanner;
import java.util.Stack;

public class _1874 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[] sequence = new int[n];
        
        for (int i = 0; i < n; i++) {
            sequence[i] = scanner.nextInt();
        }
        
        scanner.close();
        
        Stack<Integer> stack = new Stack<>();
        StringBuilder operations = new StringBuilder();
        int current = 1;
        
        for (int i = 0; i < n; i++) {
            int target = sequence[i];
            
            if (current <= target) {
                while (current <= target) {
                    stack.push(current++);
                    operations.append("+\n");
                }
                stack.pop();
                operations.append("-\n");
            } else {
                if (stack.peek() != target) {
                    System.out.println("NO");
                    return;
                }
                stack.pop();
                operations.append("-\n");
            }
        }
        
        System.out.println(operations.toString());
    }
}
