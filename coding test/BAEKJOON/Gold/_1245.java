import java.util.*;

public class _1245 {
    static class Task implements Comparable<Task> {
        int time, deadline;
        
        Task(int time, int deadline) {
            this.time = time;
            this.deadline = deadline;
        }
        
        @Override
        public int compareTo(Task other) {
            return other.deadline - this.deadline;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        Task[] tasks = new Task[n];
        
        for (int i = 0; i < n; i++) {
            int t = scanner.nextInt();
            int s = scanner.nextInt();
            tasks[i] = new Task(t, s);
        }
        
        Arrays.sort(tasks);
        
        int currentTime = Integer.MAX_VALUE;
        
        for (Task task : tasks) {
            currentTime = Math.min(currentTime, task.deadline) - task.time;
            if (currentTime < 0) {
                System.out.println(-1);
                scanner.close();
                return;
            }
        }
        
        System.out.println(currentTime);
        scanner.close();
    }
}
