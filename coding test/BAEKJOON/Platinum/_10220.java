import java.util.Scanner;
public class _10220 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int x = sc.nextInt();
            if (x == 1 || x == 2 || x == 3 || x == 6) {
                System.out.println(0);
            } else if (x == 4) {
                System.out.println(2);
            } else {
                System.out.println(1);
            }
        }
        sc.close();
    }
}