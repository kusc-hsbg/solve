import java.util.*;

public class _1124 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        scanner.close();
        
        boolean[] isPrime = new boolean[100001];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= 100000; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= 100000; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        int[] primeFactorsCount = new int[100001];
        for (int i = 2; i <= 100000; i++) {
            int num = i;
            int count = 0;
            for (int j = 2; j * j <= num; j++) {
                while (num % j == 0) {
                    count++;
                    num /= j;
                }
            }
            if (num > 1) {
                count++;
            }
            primeFactorsCount[i] = count;
        }
        
        int underprimeCount = 0;
        for (int i = A; i <= B; i++) {
            if (isPrime[primeFactorsCount[i]]) {
                underprimeCount++;
            }
        }
        
        System.out.println(underprimeCount);
    }
}
