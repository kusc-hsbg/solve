import java.util.Scanner;
import java.util.TreeSet;

public class _1539 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Node> treeSet = new TreeSet<>();
        long sum = 0;
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            Node currentNode = new Node(value);

            Node lower = treeSet.lower(currentNode);
            Node higher = treeSet.higher(currentNode);

            int leftHeight = (lower != null) ? lower.height : 0;
            int rightHeight = (higher != null) ? higher.height : 0;
            currentNode.height = Math.max(leftHeight, rightHeight) + 1;

            treeSet.add(currentNode);

            sum += currentNode.height;
        }

        System.out.println(sum);
        sc.close();
    }

    static class Node implements Comparable<Node> {
        int value;
        int height;

        Node(int value) {
            this.value = value;
            this.height = 0;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.value, other.value);
        }
    }
}