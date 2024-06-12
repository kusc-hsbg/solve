import java.io.*;
import java.util.*;

public class _2143 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] B = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> subArraySumsA = generateSubarraySums(A);
        List<Integer> subArraySumsB = generateSubarraySums(B);

        Map<Integer, Integer> sumCountB = new HashMap<>();
        for (int sum : subArraySumsB) {
            sumCountB.put(sum, sumCountB.getOrDefault(sum, 0) + 1);
        }

        long count = 0;
        for (int sumA : subArraySumsA) {
            int targetB = T - sumA;
            if (sumCountB.containsKey(targetB)) {
                count += sumCountB.get(targetB);
            }
        }

        System.out.println(count);
    }

    private static List<Integer> generateSubarraySums(int[] array) {
        List<Integer> subArraySums = new ArrayList<>();
        int n = array.length;

        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            for (int j = i; j < n; j++) {
                currentSum += array[j];
                subArraySums.add(currentSum);
            }
        }

        return subArraySums;
    }
}
