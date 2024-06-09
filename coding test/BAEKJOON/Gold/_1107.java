import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class _1107 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int targetChannel = scanner.nextInt();
        int brokenButtonCount = scanner.nextInt();
        Set<Integer> brokenButtons = new HashSet<>();

        for (int i = 0; i < brokenButtonCount; i++) {
            brokenButtons.add(scanner.nextInt());
        }

        scanner.close();

        int minClicks = Math.abs(targetChannel - 100);

        for (int i = 0; i <= 1000000; i++) {
            String channelStr = String.valueOf(i);
            boolean isBroken = false;

            for (char ch : channelStr.toCharArray()) {
                if (brokenButtons.contains(ch - '0')) {
                    isBroken = true;
                    break;
                }
            }

            if (!isBroken) {
                int clicks = Math.abs(i - targetChannel) + channelStr.length();
                if (clicks < minClicks) {
                    minClicks = clicks;
                }
            }
        }

        System.out.println(minClicks);
    }
}