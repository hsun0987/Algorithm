import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 1. 각 부모노드를 저장하는 배열 생성
        // 2. 수열 계산
        //  - 1보다 차이가 나면 다른 부모 -> depth 증가
        //  - k가 나왔을 때 노드번호 저장
        // 3. 형제 노드 찾기
        //  - k의 부모와 다르고 두번째 부모가 같은 노드

        while(true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if (n == 0 && k == 0) {
                break;
            }

            st = new StringTokenizer(br.readLine());
            int[] arr = new int[n+1];
            int[] parent = new int[n+1];

            // 루트[1] 과 겹치는 것 방지
            parent[0] = -1;
            arr[0] = -1;
            int depth = -1;
            int target = 0;

            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if(arr[i-1] + 1 != arr[i]){
                    depth ++;
                }
                if(arr[i] == k){
                    // k를 찾았을 때 노드번호 저장
                    target = i;
                }
                // 부모 저장
                parent[i] = depth;
            }

            int answer = 0;
            for (int i = 1; i <= n; i++) {
                // 부모가 다르고 그 윗 부모가 같으면 형제노드
                if(parent[i] != parent[target] && parent[parent[i]] == parent[parent[target]])
                    answer++;
            }

            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
    }
}