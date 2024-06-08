import java.util.Scanner;

public class _16769 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] capacity = new int[3];
        int[] milk = new int[3];

        for (int i = 0; i < 3; i++) {
            capacity[i] = scanner.nextInt();
            milk[i] = scanner.nextInt();
        }
        
        scanner.close();

        for (int i = 0; i < 100; i++) {
            int from = i % 3;
            int to = (i + 1) % 3;
            pourMilk(milk, capacity, from, to);
        }

        for (int i = 0; i < 3; i++) {
            System.out.println(milk[i]);
        }
    }

    private static void pourMilk(int[] milk, int[] capacity, int from, int to) {
        int pourAmount = Math.min(milk[from], capacity[to] - milk[to]);
        milk[from] -= pourAmount;
        milk[to] += pourAmount;
    }
}
