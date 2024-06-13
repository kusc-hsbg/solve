import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int M = Integer.parseInt(br.readLine());
        int bitmask = 0;

        for (int i = 0; i < M; i++) {
            String[] command = br.readLine().split(" ");
            String operation = command[0];

            if (operation.equals("add")) {
                int x = Integer.parseInt(command[1]);
                bitmask |= (1 << (x - 1));
            } else if (operation.equals("remove")) {
                int x = Integer.parseInt(command[1]);
                bitmask &= ~(1 << (x - 1));
            } else if (operation.equals("check")) {
                int x = Integer.parseInt(command[1]);
                int result = (bitmask & (1 << (x - 1))) != 0 ? 1 : 0;
                sb.append(result).append("\n");
            } else if (operation.equals("toggle")) {
                int x = Integer.parseInt(command[1]);
                bitmask ^= (1 << (x - 1));
            } else if (operation.equals("all")) {
                bitmask = (1 << 20) - 1;
            } else if (operation.equals("empty")) {
                bitmask = 0;
            }
        }

        System.out.print(sb.toString());
    }
}
