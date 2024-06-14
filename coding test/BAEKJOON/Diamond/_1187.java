import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _1187 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int n = sc.nextInt();
            List<Pair> p = new ArrayList<>();
            
            for (int i = 1; i <= 2 * n - 1; i++) {
                int k = sc.nextInt();
                List<Integer> v = new ArrayList<>();
                v.add(k);
                p.add(new Pair(k, v));
            }

            while (p.size() > 1) {
                List<Pair> t = new ArrayList<>();
                List<Pair> evenList = new ArrayList<>();
                List<Pair> oddList = new ArrayList<>();

                for (Pair i : p) {
                    if (i.first % 2 == 0) {
                        evenList.add(i);
                    } else {
                        oddList.add(i);
                    }
                }

                for (int i = 1; i < evenList.size(); i += 2) {
                    Pair temp = new Pair((evenList.get(i).first + evenList.get(i - 1).first) / 2);
                    temp.second.addAll(evenList.get(i).second);
                    temp.second.addAll(evenList.get(i - 1).second);
                    t.add(temp);
                }

                for (int i = 1; i < oddList.size(); i += 2) {
                    Pair temp = new Pair((oddList.get(i).first + oddList.get(i - 1).first) / 2);
                    temp.second.addAll(oddList.get(i).second);
                    temp.second.addAll(oddList.get(i - 1).second);
                    t.add(temp);
                }

                p = t;
            }

            for (int i : p.get(0).second) {
                System.out.print(i + " ");
            }
        } finally {
            sc.close();
        }
    }

    static class Pair {
        int first;
        List<Integer> second;

        Pair(int first) {
            this.first = first;
            this.second = new ArrayList<>();
        }

        Pair(int first, List<Integer> second) {
            this.first = first;
            this.second = second;
        }
    }
}
