import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;

public class _1764 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine(); 
        
        Set<String> unheard = new HashSet<>();
        Set<String> unseen = new HashSet<>();
        
        for (int i = 0; i < N; i++) {
            unheard.add(scanner.nextLine());
        }
        
        for (int i = 0; i < M; i++) {
            unseen.add(scanner.nextLine());
        }
        
        unheard.retainAll(unseen);
        ArrayList<String> result = new ArrayList<>(unheard);
        Collections.sort(result);
        
        System.out.println(result.size());
        for (String name : result) {
            System.out.println(name);
        }
        
        scanner.close();
    }
}
