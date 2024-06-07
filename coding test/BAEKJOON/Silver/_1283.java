import java.util.*;

public class _1283 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        
        List<String> options = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            options.add(scanner.nextLine());
        }
        
        Set<Character> usedShortcuts = new HashSet<>();
        List<String> result = new ArrayList<>();
        
        for (String option : options) {
            String[] words = option.split(" ");
            boolean shortcutAssigned = false;
            
            for (int i = 0; i < words.length; i++) {
                char firstChar = Character.toLowerCase(words[i].charAt(0));
                if (!usedShortcuts.contains(firstChar)) {
                    usedShortcuts.add(firstChar);
                    words[i] = "[" + words[i].charAt(0) + "]" + words[i].substring(1);
                    shortcutAssigned = true;
                    break;
                }
            }
            
            if (!shortcutAssigned) {
                outer: for (int i = 0; i < words.length; i++) {
                    for (int j = 1; j < words[i].length(); j++) {
                        char ch = Character.toLowerCase(words[i].charAt(j));
                        if (!usedShortcuts.contains(ch)) {
                            usedShortcuts.add(ch);
                            words[i] = words[i].substring(0, j) + "[" + words[i].charAt(j) + "]" + words[i].substring(j + 1);
                            shortcutAssigned = true;
                            break outer;
                        }
                    }
                }
            }
            
            result.add(String.join(" ", words));
        }
        
        for (String res : result) {
            System.out.println(res);
        }
        
        scanner.close();
    }
}
