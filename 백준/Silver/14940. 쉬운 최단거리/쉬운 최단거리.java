import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph;
    static int[][] len;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static Queue<int[]> q;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 그래프 만들기
        // 2. 각 위치 별 2까지 얼마나 걸리는지 탐색
        // - 상하좌우를 비교하며 갈 수 있는 길 탐색
        // 3. 지나가는 곳(len) 누적

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int x = 0, y = 0;

        graph = new int[n+1][m+1];
        for (int i = 1; i < n+1; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 1; j < m+1; j++) {
                if (str[j-1].equals("1")) {
                    graph[i][j] = 1;
                } else if (str[j-1].equals("2")) {
                    // 도착할 지점을 먼저 구함
                    graph[i][j] = 2;
                    x = i;
                    y = j;
                }
            }
        }

        len = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];
        q = new LinkedList<>();
        // 도착할 지점(2)부터 시작
        bfs(x, y);

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (graph[i][j] != 0 && !visited[i][j]){
                    bw.write("-1 ");
                }else{
                    bw.write(len[i][j] + " ");
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();

    }

    public static void bfs(int x, int y){
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + cur[0];
                int ny = dy[i] + cur[1];

                // 배열의 크기 범위 주의
                if (nx >= 0 && ny >= 0 && nx < n+1 && ny < m+1){
                    if (!visited[nx][ny] && graph[nx][ny] == 1){
                        q.add(new int[]{nx, ny});
                        len[nx][ny] = len[cur[0]][cur[1]] + 1;
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}