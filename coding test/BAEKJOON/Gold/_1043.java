import java.util.*;

public class _1043 {
    
    static int[] parent;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        
        int truthCount = scanner.nextInt();
        Set<Integer> truthPeople = new HashSet<>();
        for (int i = 0; i < truthCount; i++) {
            truthPeople.add(scanner.nextInt());
        }
        
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        
        List<List<Integer>> parties = new ArrayList<>();
        
        for (int i = 0; i < M; i++) {
            int partySize = scanner.nextInt();
            List<Integer> party = new ArrayList<>();
            for (int j = 0; j < partySize; j++) {
                party.add(scanner.nextInt());
            }
            parties.add(party);
            
            for (int j = 1; j < party.size(); j++) {
                union(party.get(0), party.get(j));
            }
        }
        
        Set<Integer> truthRoots = new HashSet<>();
        for (int person : truthPeople) {
            truthRoots.add(find(person));
        }
        
        int maxExaggeratedParties = 0;
        
        for (List<Integer> party : parties) {
            boolean canExaggerate = true;
            for (int person : party) {
                if (truthRoots.contains(find(person))) {
                    canExaggerate = false;
                    break;
                }
            }
            if (canExaggerate) {
                maxExaggeratedParties++;
            }
        }
        
        System.out.println(maxExaggeratedParties);
        scanner.close();
    }
    
    public static int find(int a) {
        if (parent[a] != a) {
            parent[a] = find(parent[a]);
        }
        return parent[a];
    }
    
    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }
}
