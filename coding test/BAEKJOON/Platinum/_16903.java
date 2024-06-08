import java.io.*;
import java.util.*;

public class _16903 {
    static final PScanner sc = new PScanner(System.in);
    static final PWriter out = new PWriter(System.out);

    static void solve() {
        int M = sc.nextInt();
        IntTrie trie = new IntTrie();
        trie.add(0);
        for (int m = 0; m < M; m++) {
            int t = sc.nextInt();
            int x = sc.nextInt();
            if (t == 1) {
                trie.add(x);
            } else if (t == 2) {
                trie.remove(x);
            } else {
                out.println(trie.query(x));
            }
        }
    }

    static class IntTrie {
        private final Node root;
        private static final int BITS = 30; // enough to cover numbers up to 1_000_000_000

        public IntTrie() {
            root = new Node();
        }

        public void add(int value) {
            Node node = root;
            for (int i = BITS - 1; i >= 0; i--) {
                int bit = (value >> i) & 1;
                if (node.children[bit] == null) {
                    node.children[bit] = new Node();
                }
                node = node.children[bit];
                node.count++;
            }
        }

        public void remove(int value) {
            Node node = root;
            for (int i = BITS - 1; i >= 0; i--) {
                int bit = (value >> i) & 1;
                node = node.children[bit];
                node.count--;
            }
        }

        public int query(int value) {
            Node node = root;
            int xor = 0;
            for (int i = BITS - 1; i >= 0; i--) {
                int bit = (value >> i) & 1;
                if (node.children[bit ^ 1] != null && node.children[bit ^ 1].count > 0) {
                    xor |= (1 << i);
                    node = node.children[bit ^ 1];
                } else {
                    node = node.children[bit];
                }
            }
            return xor;
        }

        private static class Node {
            private final Node[] children;
            private int count;

            public Node() {
                children = new Node[2];
                count = 0;
            }
        }
    }

    public static void main(String[] args) {
        solve();
        out.flush();
    }

    static class PScanner {
        private final BufferedReader br;
        private StringTokenizer st;

        public PScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }

        public boolean hasNext() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    if ((st = new StringTokenizer(br.readLine())) == null) {
                        return false;
                    }
                } catch (IOException e) {
                    return false;
                }
            }
            return true;
        }

        public String next() {
            return hasNext() ? st.nextToken() : null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }

    static class PWriter {
        private final BufferedWriter bw;

        public PWriter(OutputStream out) {
            bw = new BufferedWriter(new OutputStreamWriter(out));
        }

        public void flush() {
            try {
                bw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void println(int i) {
            try {
                bw.write(Integer.toString(i));
                bw.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
