import java.io.*;
import java.util.*;

public class _1759 {
    static int L, C;
    static char[] chars;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        chars = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            chars[i] = st.nextToken().charAt(0);
        }
        
        Arrays.sort(chars); 
        backtrack(0, 0, 0, 0, new char[L]);
        
        System.out.print(sb.toString());
    }
    
    static void backtrack(int start, int depth, int vowels, int consonants, char[] password) {
        if (depth == L) {
            if (vowels >= 1 && consonants >= 2) {
                sb.append(new String(password)).append('\n');
            }
            return;
        }
        
        for (int i = start; i < C; i++) {
            char c = chars[i];
            password[depth] = c;
            
            if (isVowel(c)) {
                backtrack(i + 1, depth + 1, vowels + 1, consonants, password);
            } else {
                backtrack(i + 1, depth + 1, vowels, consonants + 1, password);
            }
        }
    }
    
    static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
