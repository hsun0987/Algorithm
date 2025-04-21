import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] graph;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        1. 그래프 만들기
//        2. dfs 함수 구현
//        3. 방문했을 시 visited 1→0 변경
//        4. 재귀로 인접한 1을 다 돌고 오면 count +1

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            graph = new boolean[52][52];
            visited = new boolean[52][52];

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[y+1][x+1] = true;
            }

            int answer = 0;
            for (int x = 1; x < n+1; x++) {
                for (int y = 1; y < m+1; y++) {
                    if (graph[x][y] && !visited[x][y]) {
                        dfs(x, y);
                        answer++;
                    }
                }
            }
            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
    }

    static void dfs(int x, int y){
        visited[x][y] = true;

        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (graph[nx][ny] && !visited[nx][ny]){
                dfs(nx, ny);
            }
        }
    }
}