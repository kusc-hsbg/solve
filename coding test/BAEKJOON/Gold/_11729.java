import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class _11729 {

    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        int K = (1 << N) - 1;
        System.out.println(K);

        hanoi(N, 1, 2, 3);
        bw.flush();
        bw.close();
    }

    private static void hanoi(int n, int from, int via, int to) throws IOException {
        if (n == 1) {
            bw.write(from + " " + to + "\n");
            return;
        }
        hanoi(n - 1, from, to, via); 
        bw.write(from + " " + to + "\n"); 
        hanoi(n - 1, via, from, to); 
    }
}
