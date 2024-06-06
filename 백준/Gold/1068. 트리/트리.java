import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static HashMap<Integer, ArrayList<Integer>> table;
    static int answer = 0;
    static int rmIdx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 1. 입력 값을 부모, 자식 노드 테이블에 각각 저장
        // 2. 노드 삭제 시 자식노드도 모두 삭제 -> 해당 노드 제외하고 탐색!! (삭제할 필요X)
        // 3. dfs를 이용하여 리프노드 개수 세기

        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n];

        // root != 0 일 경우 대비
        int root = -1;

        // 노드 테이블
        table = new HashMap<>();
        for (int i = 0; i < n; i++) {
            table.put(i, new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(st.nextToken());
            if(p == -1){
                // i가 루트 노드임
                root = i;
                p = i;
            }
            // 부모와 자식 노드 서로 저장
            table.get(i).add(p);
            table.get(p).add(i);
        }

        rmIdx = Integer.parseInt(br.readLine());
        if(rmIdx == root){
            System.out.println(0);
            return;
        }else {
            dfs(root);
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }

    static void dfs(int node){
        visited[node] = true;
        // 자식 노드 개수
        int nodes = 0;
        for (int next : table.get(node)) {
            // 삭제된 노드는 제외
            if(next != rmIdx && !visited[next]){
                nodes++;
                dfs(next);
            }
        }
        // 자식노드가 없으면 리프 노드임
        if (nodes == 0){
            answer++;
        }
    }
}
