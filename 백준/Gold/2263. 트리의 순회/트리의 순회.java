import java.io.*;
import java.util.*;

public class Main {
    static int[] inorder;
    static int[] postorder;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 1. 후위순회의 가장 오른쪽 값이 루트
        // 2. 루트를 기준으로 중위순회를 봤을 때 왼쪽인지 오른쪽인지 확인
        
        int n = Integer.parseInt(br.readLine());

        // 중위순회 입력
        inorder = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
        }

        // 후위순회 입력
        postorder = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }

        preOrder(0, n-1, 0, n-1);

        bw.write(sb.toString() + "");
        bw.flush();
        bw.close();
    }
    static void preOrder(int is, int ie, int ps, int pe){
        // index 넘어가는 것 방지
        if (is <= ie && ps <= pe) {
            // root
            int r = postorder[pe];

            // inorder 탐색
            for (int i = is; i <= ie; i++) {
                if(inorder[i] == r){
                    sb.append(r).append(" ");
                    // left
                    preOrder( is, i - 1, ps, ps + i - is - 1);
                    // right
                    preOrder(i + 1, ie, ps + i - is, pe - 1);

                    return;
                }
            }
        }
    }
}