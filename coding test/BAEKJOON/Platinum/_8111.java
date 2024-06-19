import java.io.*;
import java.util.*;
public class _8111 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        StringBuilder output = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(reader.readLine());
            output.append(findSmallestBinaryMultiple(N)).append("\n");
        }
        System.out.print(output.toString());
    }
    private static String findSmallestBinaryMultiple(int N) {
        Queue<String> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add("1");
        while (!queue.isEmpty()) {
            String current = queue.poll();
            int remainder = 0;
            for (char ch : current.toCharArray()) {
                remainder = (remainder * 10 + (ch - '0')) % N;
            }
            if (remainder == 0) {
                return current;
            }
            if (!visited.contains(remainder)) {
                visited.add(remainder);
                queue.add(current + "0");
                queue.add(current + "1");
            }
        }
        return "BRAK";
    }
}