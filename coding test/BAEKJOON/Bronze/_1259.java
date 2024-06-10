// import java.util.*;
import java.io.*;

public class _1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        
        while (!(line = reader.readLine()).equals("0")) {
            if (isPalindrome(line)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }

        reader.close();
    }

    private static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}
