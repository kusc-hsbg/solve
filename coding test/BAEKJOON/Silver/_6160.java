import java.util.*;
import java.io.*;

public class _6160 {

    private static class Vote implements Comparable<Vote> {
        private int index;
        private int first;
        private int second;

        public Vote(int index, int first, int second) {
            this.index = index;
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Vote o) {
            return Integer.compare(o.first, this.first);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        PriorityQueue<Vote> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int firstVotes = Integer.parseInt(st.nextToken());
            int secondVotes = Integer.parseInt(st.nextToken());
            priorityQueue.add(new Vote(i + 1, firstVotes, secondVotes));
        }

        int maxSecondVotes = 0;
        int winningIndex = 0;
        for (int i = 0; i < k; i++) {
            Vote vote = priorityQueue.poll();
            if (vote.second > maxSecondVotes) {
                maxSecondVotes = vote.second;
                winningIndex = vote.index;
            }
        }

        System.out.println(winningIndex);
    }
}
