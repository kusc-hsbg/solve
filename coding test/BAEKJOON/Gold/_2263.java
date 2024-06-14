import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class _2263 {
    static int[] inorder;
    static int[] postorder;
    static int[] indexMap;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        inorder = new int[n];
        postorder = new int[n];
        indexMap = new int[n + 1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
            indexMap[inorder[i]] = i;
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }
        
        getPreorder(0, n - 1, 0, n - 1);
        
        System.out.println(sb.toString());
    }
    
    static void getPreorder(int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return;
        }
        
        int root = postorder[postEnd];
        sb.append(root).append(' ');
        int inRootIndex = indexMap[root];
        int leftSubtreeSize = inRootIndex - inStart;
        
        getPreorder(inStart, inRootIndex - 1, postStart, postStart + leftSubtreeSize - 1);
        getPreorder(inRootIndex + 1, inEnd, postStart + leftSubtreeSize, postEnd - 1);
    }
}
