import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int n;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n+1];

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        answer = 0;
        dfs(1, 0);

        if (answer % 2 == 0){
            bw.write("No");
        }else{
            bw.write("Yes");
        }

        bw.flush();
        bw.close();
    }
    // 전역 변수로 사용 x depth를 매개변수로 받음 -> 재귀로 받은 부모 노드에 + 1 하도록
    public static void dfs(int idx, int depth){
        visited[idx] = true;

        for (int i : graph.get(idx)) {
            if(!visited[i]){
                // 방문할 때마다 깊이 + 1
                dfs(i, depth + 1);
            }
        }
        // 특정 노드가 루트가 아니고 인접리스트 사이즈가 1이면 리프노드
        // 리프노드일 때 간선의 합을 구한다
        if(idx != 1 && graph.get(idx).size() == 1){
            answer += depth;
        }
    }
}