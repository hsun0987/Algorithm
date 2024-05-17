import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] graph;
    static int[] visited;
    static int n, m;
    static Queue<Integer> q;
    static int[] count;

    public static void bfs(int idx) throws IOException{
        q.add(idx);
        visited[idx] = 1;

        while(!q.isEmpty()){
            // 1. 큐에서 처음값 pop
            int node = q.poll();
            for (int i = 1; i <= n; i++) {
                if(visited[i] == 0 && graph[node][i]){
                    // 2. 나온 인덱스에 연결된 노드 값 큐에 담기
                    q.add(i);
                    // 다음노드 방문 횟수 = 이전노드 방문 횟수 + 1
                    if(node == idx){
                        visited[i] = 1;
                        continue;
                    }
                    visited[i] = visited[node] + 1;
                }
            }
        }
        for (int i = 1; i < n+1; i++) {
            if(i == idx){
                continue;
            }
            count[idx] += visited[i];
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

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = true;
            graph[y][x] = true;
        }

        count = new int[n+1];
        q = new LinkedList<>();
        for (int i = 1; i < n+1; i++) {
            // 노드의 시작이 바뀔 때마다 방문횟수 초기화
            visited = new int[n+1];
            bfs(i);
        }

        // 케빈 베이컨의 수가 가장 작은 사람 저장
        int min = Integer.MAX_VALUE;
        int answer = 0;
        for (int i = 1; i <= n; i++) {
                if (min > count[i]){
                    min = count[i];
                    answer = i;
                }
        }
        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
}