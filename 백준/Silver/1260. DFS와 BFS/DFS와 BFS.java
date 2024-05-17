import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] graph;
    static boolean[] visited;
    static int n, m;
    static BufferedWriter bw;
    static Queue<Integer> q;

    public static void dfs(int idx) throws IOException{
        visited[idx] = true;
        bw.write(idx + " ");
        for (int i = 1; i <= n; i++) {
            if(!visited[i] && graph[idx][i]){
                dfs(i);
            }
        }
    }

    public static void bfs(int idx) throws IOException{
        q.add(idx);
        visited[idx] = true;

        while(!q.isEmpty()){
            // 1. 큐에서 처음값 pop
            int node = q.poll();
            bw.write(node + " ");
            for (int i = 1; i <= n; i++) {
                if(!visited[i] && graph[node][i]){
                    // 2. 나온 인덱스에 연결된 노드 값 큐에 담기
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      bw = new BufferedWriter(new OutputStreamWriter(System.out));

      String[] input = br.readLine().split(" ");
      // 정점(노드)
      n = Integer.parseInt(input[0]);
      // 간선
      m = Integer.parseInt(input[1]);
      // 시작 노드
      int v = Integer.parseInt(input[2]);

      // 인접 리스트 생성
      graph = new boolean[n+1][n+1];

    for (int i = 0; i < m; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        graph[x][y] = true;
        graph[y][x] = true;
    }

    visited = new boolean[n+1];
    dfs(v);
    bw.write("\n");

    visited = new boolean[n+1];
    q = new LinkedList<>();
    bfs(v);

    bw.flush();
    bw.close();
    }
}