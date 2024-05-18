import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] graph;
    static boolean[][] visited;
    static int n, m;

    public static void dfs(int x, int y){
        // 상하좌우 좌표
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        visited[y][x] = true;

        // 상하좌우 중 1이고 방문 하지 않은 곳 방문
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(graph[nextY][nextX] && !visited[nextY][nextX]){
                dfs(nextX, nextY);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tcase = Integer.parseInt(br.readLine());

        for (int i = 0; i < tcase; i++) {
            String[] input = br.readLine().split(" ");
            // 가로
            m = Integer.parseInt(input[0]);
            // 세로
            n = Integer.parseInt(input[1]);
            // 간선
            int k = Integer.parseInt(input[2]);

            // 인접 리스트 생성
            graph = new boolean[60][60];
            visited = new boolean[60][60];

            for (int j = 0; j < k; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph[v+1][u+1] = true;
            }

            int answer = 0;
            for (int y = 1; y <= n; y++) {
                for (int x = 1; x <= m; x++) {
                    if (graph[y][x] && !visited[y][x]) {
                        dfs(x, y);
                        // dfs를 호출한 횟수가 답
                        answer++;
                    }
                }
            }
            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();

    }
}