import java.util.Scanner;

public class _15829 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int L = scanner.nextInt();
        String str = scanner.next();
        scanner.close();

        long hashValue = 0;
        long r = 31;
        long M = 1234567891;
        long power = 1;

        for (int i = 0; i < L; i++) {
            int charValue = str.charAt(i) - 'a' + 1;
            hashValue = (hashValue + charValue * power) % M;
            power = (power * r) % M;
        }

        System.out.println(hashValue);
    }
}
