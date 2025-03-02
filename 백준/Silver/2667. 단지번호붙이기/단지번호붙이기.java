import java.io.*;
import java.util.*;

public class Main {
    static int[][] visited;
    static int[][] graph;
    static int[][] direction;
    static Queue<int[]> q;
    static int home;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 그래프 만들기
        // 2. visited 에 연결된 단지 내 집 수 누적
        // - 상하좌우 비교 후 인접하면 탐색
        // 3. 배열에 연결 단지 내 집 수 저장
        // 4. 방문 안한곳 다시 탐색 -> 먼저 1이 있는지 확인 후 있으면 bfs 돌리기

        int n = Integer.parseInt(br.readLine());

        graph = new int[n+2][n+2];
        for (int i = 1; i < n+1; i++) {
            String str = br.readLine();
            for (int j = 1; j < n+1; j++) {
                if (str.charAt(j-1) == '1'){
                    graph[i][j] = 1;
                }
            }
        }

        // 누적 거리 저장
        visited = new int[n+1][n+1];
        // 상 하 좌 우
        direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        q = new LinkedList<>();
        ArrayList<Integer> homes = new ArrayList<>();

        // 1이 있을 경우 bfs 실행
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (graph[i][j] == 1 && visited[i][j] != 1){
                    home = 1;
                    dfs(i, j);
                    homes.add(home);
                }
            }
        }

        // 단지 수 오름차순 정렬
        Collections.sort(homes);

        bw.write(homes.size() + "\n");
        for (int i : homes){
            bw.write(i + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static void dfs(int si, int sj){
        visited[si][sj] = 1;

        // 상하좌우 방향 내에서
        for (int[] dir : direction) {
            // 현재 좌표에서 이동
            int ni = si + dir[0];
            int nj = sj + dir[1];

            if (0 <= ni && 0 <= nj && graph[ni][nj] == 1 && visited[ni][nj] == 0){
                home++;
                dfs(ni, nj);
            }
        }
    }
}