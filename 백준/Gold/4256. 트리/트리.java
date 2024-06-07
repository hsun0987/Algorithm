import java.io.*;
import java.util.*;

public class Main {
    static int[] preorder;
    static int[] inorder;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 1. 전위 순회를 통해 root를 알아낼 수 있다 (VLR)
        // 2. 중위 순회를 통해 root를 기준으로 왼쪽 오른쪽 방향을 구한다 (LVR)
        // -> 재귀 이용

        int t = Integer.parseInt(br.readLine());
        while (t --> 0){
            int n = Integer.parseInt(br.readLine());

            // 전위 순회
            preorder = new int[n+1];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                preorder[i] = Integer.parseInt(st.nextToken());
            }
            // 중위 순회
            inorder = new int[n+1];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                inorder[i] = Integer.parseInt(st.nextToken());
            }
            postorder(0, 0, n);
            sb.append("\n");
        }

        bw.write(sb.toString() + "");
        bw.flush();
        bw.close();
    }

    static void postorder(int root, int start, int end){
        // root
        int r = preorder[root];

        // inorder 탐색
        for (int i = start; i < end; i++) {
            // inorder에서 root를 찾는다
            if (inorder[i] == r){
                // left = root + 1, i를 기준으로 앞
                postorder(root + 1, start, i);
                // right = root + left 자식수(i - start) + 1, i를 기준으로 뒤
                postorder(root + (i - start) + 1, i + 1, end);
                sb.append(r).append(" ");
                return;
            }
        }
    }

}