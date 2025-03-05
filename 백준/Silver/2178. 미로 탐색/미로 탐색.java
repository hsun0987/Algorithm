import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph;
    static int[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static Queue<int[]> q;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 그래프 만들기
        // 2. 상하좌우를 비교하며 갈 수 있는 길 탐색
        // 3. 지나가는 곳(visited) 누적

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n+1][m+1];
        for (int i = 1; i < n+1; i++) {
            String str = br.readLine();
            for (int j = 1; j < m+1; j++) {
                if (str.charAt(j-1) == '1'){
                    graph[i][j] = 1;
                }
            }
        }

        visited = new int[n+1][m+1];
        q = new LinkedList<>();
        int answer = bfs(1, 1);

        bw.write(answer + "");
        bw.flush();
        bw.close();

    }

    public static int bfs(int x, int y){
        q.add(new int[]{x, y});
        visited[x][y] = 1;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            if (cur[0] == n && cur[1] == m){
                return visited[n][m];
            }

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + cur[0];
                int ny = dy[i] + cur[1];

                // 배열의 크기 범위 주의
                if (nx >= 0 && ny >= 0 && nx < n+1 && ny < m+1){
                    if (visited[nx][ny] == 0 && graph[nx][ny] == 1){
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = visited[cur[0]][cur[1]] + 1;
                    }
                }
            }
        }
        return visited[n][m];
    }
}