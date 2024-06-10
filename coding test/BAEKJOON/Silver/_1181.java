import java.util.*;
import java.io.*;

public class _1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        Set<String> wordSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            wordSet.add(reader.readLine());
        }

        List<String> wordList = new ArrayList<>(wordSet);
        wordList.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() != s2.length()) {
                    return s1.length() - s2.length();
                } else {
                    return s1.compareTo(s2);
                }
            }
        });

        for (String word : wordList) {
            System.out.println(word);
        }

        reader.close();
    }
}
