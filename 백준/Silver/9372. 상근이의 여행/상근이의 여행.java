import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] tree;
    static boolean[] visited;
    static int answer;
    static Queue<Integer> q;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 1. 연결 그래프 생성
        // 2. bfs 이용 -> visited 했을 때 count

        int t = Integer.parseInt(br.readLine());
        while (t --> 0){
            st = new StringTokenizer(br.readLine());
            // 노드 수
            n = Integer.parseInt(st.nextToken());
            // 간선 수
            int m = Integer.parseInt(st.nextToken());
            // 답 초기화
            answer = 0;

            tree = new boolean[n+1][n+1];
            visited = new boolean[n+1];
            q = new LinkedList<>();

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                tree[a][b] = true;
                tree[b][a] = true;
            }
            bfs(1);
            bw.write(answer - 1 + "\n");
        }
        bw.flush();
        bw.close();
    }
    static void bfs(int idx){
        q.add(idx);
        visited[idx] = true;

        while(!q.isEmpty()){
            answer++;
            // 1. 큐에서 처음값 pop
            int node = q.poll();
            for (int i = 1; i <= n; i++) {
                if(!visited[i] && tree[node][i]){
                    // 2. 나온 인덱스에 연결된 노드 값 큐에 담기
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}