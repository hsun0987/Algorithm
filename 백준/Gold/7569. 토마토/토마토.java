import java.io.*;
import java.util.*;

public class Main {
    static int[][][] graph;
    static Queue<int[]> q;
    static int dir[][] = new int[][]{{0, -1, 0}, {0, 1, 0}, {-1, 0, 0}, {1, 0, 0}, {0, 0, 1}, {0, 0, -1}};
    static int n, m, h;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // ** 3차원 배열로 높이 인접한 곳도 고려
        // bfs -> 각 토마토 위치에서 주변 토마토를 익게 만듦
        // 익은: 1, 안익은: 0, 빈: -1
        // 1. 그래프 생성, 방문여부 배열
        // 2. 익은 토마토를 찾아서 인접한 안익은 토마토에 값 누적
        // 3. 미리 1이 있을 때 큐에 넣기
        // 4. 그래프 내에 최댓값 출력
        // - 0이 남아있는 경우 -1 출력

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        graph = new int[h][n+2][m+2];
        q = new LinkedList<>();

        for (int k = 0; k < h; k++) {
            for (int i = 1; i < n+1; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 1; j < m+1; j++) {
                    graph[k][i][j] = Integer.parseInt(input[j - 1]);
                    // 미리 1을 큐에 넣어둠
                    if (graph[k][i][j] == 1) q.add(new int[]{i, j, k});
                }
            }
        }

        int answer = bfs();
        bw.write(answer + "");
        bw.flush();
        bw.close();
    }

    static int bfs() {
        int max = 0;
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            int z = current[2];

            for (int i = 0; i < 6; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                int nz = z + dir[i][2];
                if (nx > 0 && ny > 0 && nx <= n && ny <= m && nz >= 0 && nz < h && graph[nz][nx][ny] == 0) {
                    // 누적값 저장
                    graph[nz][nx][ny] += graph[z][x][y] + 1;
                    q.add(new int[]{nx, ny, nz});
                    // 최댓값 구하기
                    max = Math.max(max, graph[nz][nx][ny]);
                }
            }
        }

        for (int k = 0; k < h; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < m + 1; j++) {
                    //0이 남아있는 경우 -1 출력
                    if (graph[k][i][j] == 0) {
                        return -1;
                    }
                }
            }
        }
        // 원래 모두 익혀져있을 경우
        if (max == 0) {
            return 0;
        }

        return max-1;
    }
}