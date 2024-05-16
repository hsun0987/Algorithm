import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] graph;
    static boolean[] visited;
    static int n, m;
    static int answer;

    public static void dfs(int idx){
        answer++;
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

      // 정점(노드)
      n = Integer.parseInt(br.readLine());
      // 간선
      m = Integer.parseInt(br.readLine());

      // 인접 리스트 생성
      graph = new boolean[n+1][n+1];
      // 방문 여부 저장
      visited = new boolean[n+1];
      
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            // 인접 노드 저장
            graph[x][y] = true;
            graph[y][x] = true;
        }

        // dfs - 깊이 우선 탐색
        dfs(1);

        bw.write(answer - 1 + "");
        bw.flush();
        bw.close();

    }
}