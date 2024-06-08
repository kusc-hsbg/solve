public class _15311 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append(2000).append("\n");
        
        for (int i = 1; i <= 1000; i++) {
            sb.append(1).append(" ");
        }
        for (int i = 1; i <= 1000; i++) {
            sb.append(1000).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}