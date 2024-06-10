import java.util.*;

class Member {
    int age;
    String name;
    int order;

    public Member(int age, String name, int order) {
        this.age = age;
        this.name = name;
        this.order = order;
    }
}

public class _10814 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        List<Member> members = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            int age = scanner.nextInt();
            String name = scanner.next();
            members.add(new Member(age, name, i));
        }
        
        Collections.sort(members, new Comparator<Member>() {
            @Override
            public int compare(Member m1, Member m2) {
                if (m1.age == m2.age) {
                    return Integer.compare(m1.order, m2.order);
                }
                return Integer.compare(m1.age, m2.age);
            }
        });
        
        for (Member member : members) {
            System.out.println(member.age + " " + member.name);
        }
        
        scanner.close();
    }
}