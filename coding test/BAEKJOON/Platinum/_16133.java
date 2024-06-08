import java.io.*;
import java.util.*;

public class _16133 {
    static final PScanner sc = new PScanner(System.in);

    public static void main(String[] args) {
        String s = sc.next();
        List<String> tokens = tokenize(s);
        ListIterator<String> it = tokens.listIterator();
        System.out.println(parseExpr(it));
    }

    static List<String> tokenize(String s) {
        List<String> ret = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                StringBuilder t = new StringBuilder();
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    t.append(s.charAt(i++));
                }
                ret.add(t.toString());
            } else {
                ret.add(String.valueOf(s.charAt(i++)));
            }
        }
        ret.remove(ret.size() - 1);
        return ret;
    }

    static long parseExpr(ListIterator<String> it) {
        long ret = parseTerm(it);
        while (it.hasNext()) {
            String cmd = it.next();
            if (cmd.equals("+") || cmd.equals("-")) {
                long res = parseTerm(it);
                if (cmd.equals("+")) {
                    ret += res;
                } else {
                    ret -= res;
                }
            } else {
                it.previous();
                break;
            }
        }
        return ret;
    }

    static long parseTerm(ListIterator<String> it) {
        long ret = parseFactor(it);
        while (it.hasNext()) {
            String cmd = it.next();
            if (cmd.equals("*") || cmd.equals("/")) {
                long res = parseFactor(it);
                if (cmd.equals("*")) {
                    ret *= res;
                } else {
                    ret /= res;
                }
            } else {
                it.previous();
                break;
            }
        }
        return ret;
    }

    static long parseFactor(ListIterator<String> it) {
        long ret = parsePower(it);
        if (it.hasNext() && it.next().equals("^")) {
            long res = parseFactor(it);
            return pow(ret, res);
        }
        it.previous();
        return ret;
    }

    static long parsePower(ListIterator<String> it) {
        if (it.next().equals("#")) {
            long res = parsePower(it);
            return sqrt(res);
        }
        it.previous();
        return parseRoot(it);
    }

    static long parseRoot(ListIterator<String> it) {
        if (it.next().equals("(")) {
            long res = parseExpr(it);
            it.next(); // skip ')'
            return res;
        }
        it.previous();
        return Long.parseLong(it.next());
    }

    static long pow(long x, long n) {
        long ret = 1;
        while (n > 0) {
            if ((n & 1) == 1) ret *= x;
            x *= x;
            n >>= 1;
        }
        return ret;
    }

    static long sqrt(long x) {
        if (x <= 0) return 0;
        long lo = 1, hi = x + 1;
        while (lo + 1 < hi) {
            long mid = (lo + hi) / 2;
            if (x / mid >= mid) lo = mid;
            else hi = mid;
        }
        return lo;
    }

    static class PScanner {
        private final BufferedReader br;
        private StringTokenizer st;

        public PScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
    }
}
