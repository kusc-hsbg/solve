import java.util.LinkedList;
import java.util.Scanner;

public class _10845 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        scanner.nextLine();  
        LinkedList<Integer> queue = new LinkedList<>();
        
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String command = scanner.nextLine();

            if (command.startsWith("push")) {
                int value = Integer.parseInt(command.split(" ")[1]);
                queue.addLast(value);
            } else if (command.equals("pop")) {
                if (queue.isEmpty()) {
                    output.append(-1).append("\n");
                } else {
                    output.append(queue.pollFirst()).append("\n");
                }
            } else if (command.equals("size")) {
                output.append(queue.size()).append("\n");
            } else if (command.equals("empty")) {
                output.append(queue.isEmpty() ? 1 : 0).append("\n");
            } else if (command.equals("front")) {
                if (queue.isEmpty()) {
                    output.append(-1).append("\n");
                } else {
                    output.append(queue.peekFirst()).append("\n");
                }
            } else if (command.equals("back")) {
                if (queue.isEmpty()) {
                    output.append(-1).append("\n");
                } else {
                    output.append(queue.peekLast()).append("\n");
                }
            }
        }
        
        scanner.close();
        System.out.print(output.toString());
    }
}
