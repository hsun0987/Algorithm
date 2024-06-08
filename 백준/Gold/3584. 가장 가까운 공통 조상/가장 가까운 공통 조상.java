import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static int[] parent;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 최소 공통 조상 (LCA)
        // 1. DFS 이용하여 모든 노드의 depth 구하기 -> 메모리 초과 됨
        // 2. a, b의 depth 가 일치할 때까지 부모를 타고 올라감
        // 3. a != b 이면 동시에 부모 한칸 씩 이동

        // 다른 풀이
        // 1. a를 루트 노드까지 이동시키면서 visited 기록
        // 2. b를 루트 노드로 이동하면서 a가 방문한 노드를 처음 만나면 최소 공통 조상임

        int t = Integer.parseInt(br.readLine());
        while (t --> 0){
            st = new StringTokenizer(br.readLine());
            // 노드 수
            n = Integer.parseInt(st.nextToken());

            // 최소 부모 노드들 저장
            parent = new int[n+1];
            visited = new boolean[n+1];

            for (int i = 0; i < n-1; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                // a는 b의 부모
                parent[b] = a;
            }
            // 공통 조상을 구할 두 노드
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int answer = lca(x, y);
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
    }
    // 최소 공통 조상을 찾는 lca
    static int lca(int a, int b){
        // x 를 루트 노드까지 이동
        while (a > 0){
            visited[a] = true;
            a = parent[a];
        }
        // y 를 루트 노드까지 이동하면서 x가 방문한 노드가 있을 때 종료
        while (b > 0){
            if (visited[b]){
                return b;
            }
            b = parent[b];
        }
        return 0;
    }
}