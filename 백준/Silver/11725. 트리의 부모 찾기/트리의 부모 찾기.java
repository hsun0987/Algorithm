import java.io.*;
import java.util.*;

public class Main {
    // 부모 테이블 : 답
    static int[] parent;
    // 트리
    static ArrayList<ArrayList<Integer>> tree;
    // 방문 여부
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 모두 하나로 연결된 트리, root = 1
        // 1. 부모 테이블 생성
        // 2. 입력 받은 노드들을 양방향으로 연결 노드 저장(2차원 배열로)
        // 3. 방문 여부에 따라 부모 찾기 => DFS 이용

        int n = Integer.parseInt(br.readLine());
        parent = new int[n+1];
        tree = new ArrayList<>();
        for (int i = 1; i <= n+1; i++) {
            // 미리 저장할 arrayList 공간 생성
            tree.add(new ArrayList<>());
        }

        visited = new boolean[n+1];
        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        dfs(1);

        for (int i = 2; i < n+1; i++) {
            bw.write(parent[i] + "\n");
        }

        bw.flush();
        bw.close();
    }

    static void dfs(int node){
        // 방문 완료
        visited[node] = true;
        // 노드와 연결된 노드들 방문
        for (int next : tree.get(node)){
            // 방문하지 않았을 경우 방문
            if(!visited[next]){
                parent[next] = node;
                dfs(next);
            }
        }
    }
}