import java.util.*;

public class _1091 {
    static int n;
    static int[] s, p;
    static List<Integer> v1 = new ArrayList<>(), v2 = new ArrayList<>();
    static Set<List<Integer>> visited = new HashSet<>();

    public static void func(List<Integer> v1, List<Integer> v2) {
        for (int i = 0; i < n; i++) {
            v2.set(s[i], v1.get(i));
        }
    }

    public static int check(List<Integer> v) {
        int flag = 1;
        for (int i = 0; i < n; i++) {
            if (i % 3 != p[v.get(i)]) {
                flag = 0;
                break;
            }
        }

        if (visited.contains(v))
            flag = 2;
        else
            visited.add(new ArrayList<>(v));

        return flag;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        s = new int[n];
        p = new int[n];

        for (int i = 0; i < n; i++) {
            p[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            s[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            v1.add(i);
            v2.add(0);
        }

        int cnt = 0;
        boolean flag = false;
        while (true) {
            int tmp = 0;
            if (!flag) {
                tmp = check(v1);
                func(v1, v2);
            } else {
                tmp = check(v2);
                func(v2, v1);
            }

            if (tmp >= 1) {
                if (tmp == 2)
                    cnt = -1;
                break;
            }

            flag = !flag;
            cnt++;
        }

        System.out.println(cnt);
        scanner.close();
    }
}
