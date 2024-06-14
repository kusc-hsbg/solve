import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _3015 {

    static class Man {
        int height;
        int count;

        Man(int height, int count) {
            this.height = height;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Man> stack = new Stack<>();
        long result = 0;
        
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(br.readLine());
            int count = 1;

            while (!stack.isEmpty() && stack.peek().height <= height) {
                Man man = stack.pop();
                result += man.count;

                if (man.height == height) {
                    count += man.count;
                }
            }

            if (!stack.isEmpty()) {
                result++;
            }

            stack.push(new Man(height, count));
        }

        System.out.println(result);
    }
}
