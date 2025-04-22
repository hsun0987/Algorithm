import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] graph;
    static boolean[] visited;
    static StringBuilder sb;
    static int n;

    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        // 1. 그래프 만들기
        graph = new boolean[n+1][n+1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = true;
            graph[b][a] = true;
        }

        // 2. 초기화
        visited = new boolean[n+1];
        sb = new StringBuilder();

        // 3. dfs/bfs 호출
        dfs(v);
        sb.append("\n");

        // 다시 방문해야되니까 초기화
        visited = new boolean[n+1];
        q = new LinkedList<>();
        bfs(v);

        bw.write(sb + "");
        bw.flush();
        bw.close();
    }

    static void dfs(int idx){
        visited[idx] = true;
        // dfs를 호출했을 때 방문할 노드 출력
        sb.append(idx + " ");

        for (int i = 1; i < n+1; i++) {
            if (!visited[i] && graph[idx][i]){
                dfs(i);
            }
        }
    }

    static void bfs(int idx){
        visited[idx] = true;
        q.add(idx);

        while (!q.isEmpty()){
            int node = q.poll();
            //  다음 방문할 노드 pop할 때 출력
            sb.append(node + " ");
            for (int i = 1; i < n+1; i++) {
                if (!visited[i] && graph[node][i]){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}