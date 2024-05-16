import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] graph;
    static boolean[] visited;
    static int n, m;
    static int answer;

    public static void dfs(int idx){
        visited[idx] = true;
        for (int i = 1; i <= n; i++) {
            if(!visited[i] && graph[idx][i]){
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      String[] input = br.readLine().split(" ");
      // 정점(노드)
      n = Integer.parseInt(input[0]);
      // 간선
      m = Integer.parseInt(input[1]);

      // 인접 리스트 생성
      graph = new boolean[n+1][n+1];
      visited = new boolean[n+1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u][v] = true;
            graph[v][u] = true;
        }

        for (int i = 1; i <= n; i++) {
            if(!visited[i]){
                // dfs 깊이 우선 탐색
                dfs(i);
                answer++;
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();

    }
}