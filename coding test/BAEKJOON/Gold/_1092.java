import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class _1092 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        Integer[] cranes = new Integer[N];
        for (int i = 0; i < N; i++) {
            cranes[i] = scanner.nextInt();
        }

        int M = scanner.nextInt();
        Integer[] boxes = new Integer[M];
        for (int i = 0; i < M; i++) {
            boxes[i] = scanner.nextInt();
        }

        // 스캐너 닫기
        scanner.close();

        Arrays.sort(cranes, Collections.reverseOrder());
        Arrays.sort(boxes, Collections.reverseOrder());

        if (boxes[0] > cranes[0]) {
            System.out.println(-1);
            return;
        }

        int time = 0;
        int boxIndex = 0;
        boolean[] used = new boolean[M];

        while (boxIndex < M) {
            for (int i = 0; i < N; i++) {
                while (boxIndex < M) {
                    if (!used[boxIndex] && cranes[i] >= boxes[boxIndex]) {
                        used[boxIndex] = true;
                        boxIndex++;
                        break;
                    }
                    boxIndex++;
                }
            }
            time++;
            boxIndex = 0;
            while (boxIndex < M && used[boxIndex]) {
                boxIndex++;
            }
        }

        System.out.println(time);
    }
}
