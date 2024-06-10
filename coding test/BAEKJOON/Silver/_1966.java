import java.util.*;

public class _1966 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            
            Queue<Document> queue = new LinkedList<>();
            List<Integer> priorities = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                int priority = scanner.nextInt();
                queue.add(new Document(i, priority));
                priorities.add(priority);
            }
            
            Collections.sort(priorities, Collections.reverseOrder());
            
            int printOrder = 0;
            while (!queue.isEmpty()) {
                Document current = queue.poll();
                
                if (current.priority == priorities.get(printOrder)) {
                    printOrder++;
                    if (current.index == m) {
                        System.out.println(printOrder);
                        break;
                    }
                } else {
                    queue.add(current);
                }
            }
        }
        
        scanner.close();
    }
}

class Document {
    int index;
    int priority;
    
    Document(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }
}
