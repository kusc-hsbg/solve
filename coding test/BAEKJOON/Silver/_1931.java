import java.util.Arrays;
import java.util.Scanner;

public class _1931 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        Meeting[] meetings = new Meeting[N];
        
        for (int i = 0; i < N; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            meetings[i] = new Meeting(start, end);
        }
        scanner.close();
        
        Arrays.sort(meetings, (m1, m2) -> {
            if (m1.end == m2.end) {
                return m1.start - m2.start;
            }
            return m1.end - m2.end;
        });
        
        int count = 0;
        int lastEndTime = 0;
        
        for (Meeting meeting : meetings) {
            if (meeting.start >= lastEndTime) {
                count++;
                lastEndTime = meeting.end;
            }
        }
        
        System.out.println(count);
    }
}

class Meeting {
    int start;
    int end;
    
    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
