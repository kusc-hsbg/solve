import java.util.*;

public class _1991 {
    static class Node {
        char value;
        Node left, right;

        Node(char value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    static Map<Character, Node> tree = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            char parent = scanner.next().charAt(0);
            char left = scanner.next().charAt(0);
            char right = scanner.next().charAt(0);

            tree.putIfAbsent(parent, new Node(parent));

            if (left != '.') {
                tree.putIfAbsent(left, new Node(left));
                tree.get(parent).left = tree.get(left);
            }

            if (right != '.') {
                tree.putIfAbsent(right, new Node(right));
                tree.get(parent).right = tree.get(right);
            }
        }

        scanner.close();

        Node root = tree.get('A');

        StringBuilder preOrderResult = new StringBuilder();
        StringBuilder inOrderResult = new StringBuilder();
        StringBuilder postOrderResult = new StringBuilder();

        preorder(root, preOrderResult);
        inorder(root, inOrderResult);
        postorder(root, postOrderResult);

        System.out.println(preOrderResult.toString());
        System.out.println(inOrderResult.toString());
        System.out.println(postOrderResult.toString());
    }

    static void preorder(Node node, StringBuilder result) {
        if (node != null) {
            result.append(node.value);
            preorder(node.left, result);
            preorder(node.right, result);
        }
    }

    static void inorder(Node node, StringBuilder result) {
        if (node != null) {
            inorder(node.left, result);
            result.append(node.value);
            inorder(node.right, result);
        }
    }

    static void postorder(Node node, StringBuilder result) {
        if (node != null) {
            postorder(node.left, result);
            postorder(node.right, result);
            result.append(node.value);
        }
    }
}
