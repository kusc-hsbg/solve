import java.util.*;

public class _1141 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        List<String> v = new ArrayList<>();
        boolean[] check = new boolean[n];
        Arrays.fill(check, true);

        for (int i = 0; i < n; i++) {
            v.add(scanner.nextLine());
        }
        Collections.sort(v);
        for (int i = 0; i < v.size(); i++) {
            for (int j = i + 1; j < v.size(); j++) {
                if (v.get(j).startsWith(v.get(i))) {
                    check[i] = false;
                    break;
                }
            }
        }

        int ans = 0;
        for (boolean b : check) {
            if (b) {
                ans++;
            }
        }

        System.out.println(ans);
        scanner.close();
    }
}