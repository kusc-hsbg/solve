import java.util.Scanner;

public class _1546 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        double[] scores = new double[N];
        double maxScore = 0;

        for (int i = 0; i < N; i++) {
            scores[i] = scanner.nextDouble();
            if (scores[i] > maxScore) {
                maxScore = scores[i];
            }
        }

        scanner.close();

        double sum = 0;
        for (int i = 0; i < N; i++) {
            scores[i] = (scores[i] / maxScore) * 100;
            sum += scores[i];
        }

        double newAverage = sum / N;
        System.out.println(newAverage);
    }
}
