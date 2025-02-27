import java.io.*;
import java.util.*;

public class Main {
    static int[][] visited;
    static int[][] graph;
    static int[][] direction;
    static Queue<int[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 상하좌우 방향 중 1 여부 확인
        // visited 에 누적 거리 저장
        // 도착점까지 왔으면 visited 값 반환

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new int[n+2][m+2];
        for (int i = 1; i < n+1; i++) {
            String str = br.readLine();
            for (int j = 1; j < m+1; j++) {
                if (str.charAt(j-1) == '1'){
                    graph[i][j] = 1;
                }
            }
        }

        // 누적 거리 저장
        visited = new int[n+1][m+1];
        direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        q = new LinkedList<>();

        int answer = bfs(1, 1, n, m);

        bw.write(answer + "");

        bw.flush();
        bw.close();
    }
    public static int bfs(int si, int sj, int ei, int ej){
        // 시작 좌표를 큐에 삽입
        q.add(new int[]{si, sj});
        visited[si][sj] = 1;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            // 도착지점
            if (cur[0] == ei && cur[1] == ej){
                return visited[ei][ej];
            }

            // 상하좌우 방향 내에서
            for (int[] dir : direction) {
                // 현재 좌표에서 이동
                int ni = cur[0] + dir[0];
                int nj = cur[1] + dir[1];

                if (0 <= ni && 0 <= nj && graph[ni][nj] == 1 && visited[ni][nj] == 0){
                    q.add(new int[]{ni, nj});
                    // 거리누적
                    visited[ni][nj] = visited[cur[0]][cur[1]] + 1;
                }
            }
        }
        return 2;
    }
}