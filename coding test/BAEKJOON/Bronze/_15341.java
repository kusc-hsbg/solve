import java.util.Scanner;

public class _15341 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String line = scanner.nextLine();
            if (line.equals("0000 0000 0000 0000")) {
                break;
            }
            
            String cardNumber = line.replace(" ", "");
            if (isValidCardNumber(cardNumber)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
        scanner.close();
    }

    private static boolean isValidCardNumber(String cardNumber) {
        int totalSum = 0;
        for (int i = 0; i < cardNumber.length(); i++) {
            int digit = Character.getNumericValue(cardNumber.charAt(i));
            
            if ((i + 1) % 2 != 0) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }
            
            totalSum += digit;
        }
        
        return totalSum % 10 == 0;
    }
}
