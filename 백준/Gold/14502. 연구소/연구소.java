import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph;
    static ArrayList<int[]> virus;
    static boolean[][] visited;
    static int N, M;
    static int answer; // 안전 영역 최대 크기

    // 좌표
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int zeroCount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        virus = new ArrayList<>(); // 바이러스 좌표 미리 저장
        zeroCount = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());

                // 미리 바이러스 위치 q에 저장
                if (graph[i][j] == 2){
                    virus.add(new int[]{i, j});
                }

                if (graph[i][j] == 0){
                    zeroCount++;
                }
            }
        }


        answer = 0;
        back_track(0, 0);

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }

    static void back_track(int depth, int start){
        if (depth == 3){
            bfs();
            return;
        }

        for (int i = start; i < N*M; i++) {
            int r = i / M;
            int c = i % M;

            if(graph[r][c] != 0) continue;

            graph[r][c] = 1;
            back_track(depth+1, i+1);
            graph[r][c] = 0;
        }
    }

    static void bfs(){
        // 매번 새로 초기화 해주기
        visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        int safe = zeroCount - 3;

        for (int[] v : virus){
            q.add(v);
            visited[v[0]][v[1]] = true;
        }

        while (!q.isEmpty()){
            int[] node = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node[0] + dx[i];
                int ny = node[1] + dy[i];

                // 범위 체크
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if (!visited[nx][ny] && graph[nx][ny] == 0){
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    // 그래프 0 -> 2로 바꾸면 다시 되돌리는 작업 필요해서 복잡
                    // safe 수를 조절한다.
                    safe--;
                }
            }
        }
        answer = Math.max(answer, safe);
    }
}