import java.util.Scanner;

public class _1195 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String gearA = scanner.nextLine();
        String gearB = scanner.nextLine();
        
        scanner.close();

        int minLength = gearA.length() + gearB.length();

        // A를 고정하고 B를 오른쪽으로 이동
        for (int i = -gearB.length(); i <= gearA.length(); i++) {
            boolean canOverlap = true;
            for (int j = 0; j < gearB.length(); j++) {
                int aIndex = i + j;
                if (aIndex >= 0 && aIndex < gearA.length()) {
                    if (gearA.charAt(aIndex) == '2' && gearB.charAt(j) == '2') {
                        canOverlap = false;
                        break;
                    }
                }
            }
            if (canOverlap) {
                int left = Math.min(0, i);
                int right = Math.max(gearA.length(), i + gearB.length());
                int length = right - left;
                minLength = Math.min(minLength, length);
            }
        }

        System.out.println(minLength);
    }
}
