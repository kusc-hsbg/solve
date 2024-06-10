import java.util.LinkedList;
import java.util.Scanner;

public class _10828 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        scanner.nextLine(); 

        LinkedList<Integer> stack = new LinkedList<>();
        
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String command = scanner.nextLine();

            if (command.startsWith("push")) {
                int value = Integer.parseInt(command.split(" ")[1]);
                stack.push(value);
            } else if (command.equals("pop")) {
                if (stack.isEmpty()) {
                    output.append(-1).append("\n");
                } else {
                    output.append(stack.pop()).append("\n");
                }
            } else if (command.equals("size")) {
                output.append(stack.size()).append("\n");
            } else if (command.equals("empty")) {
                output.append(stack.isEmpty() ? 1 : 0).append("\n");
            } else if (command.equals("top")) {
                if (stack.isEmpty()) {
                    output.append(-1).append("\n");
                } else {
                    output.append(stack.peek()).append("\n");
                }
            }
        }
        
        scanner.close();
        System.out.print(output.toString());
    }
}