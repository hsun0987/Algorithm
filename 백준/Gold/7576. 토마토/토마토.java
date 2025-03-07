import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static Queue<int[]> q;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 그래프 만들기
        // - 0: 안익은 토마토, 1: 익은 토마토, -1: 빈 칸
        // 2. 1을 찾아서 그 주변에 있는 토마토를 익힌다
        // - 미리 초기에 있는 1을 찾아 큐에 넣어둔다
        // - 상하좌우를 비교하며 갈 수 있는 길 탐색
        // 3. 인접한 곳 + 1 해서 누적
        // - 기존 그래프를 활용하면 메모리 절약 가능
        // 4. 상자의 최댓값 구하기
        // - 방문x(0) 곳이 있으면 -1

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                if (str[j].equals("1")) {
                    graph[i][j] = 1;
                    q.add(new int[]{i, j});
                } else if (str[j].equals("-1")) {
                    graph[i][j] = -1;
                }
            }
        }

        bfs();

        int answer = ans();

        bw.write(answer + "");
        bw.flush();
        bw.close();

    }

    public static void bfs(){
        while(!q.isEmpty()){
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + cur[0];
                int ny = dy[i] + cur[1];

                // 배열의 크기 범위 주의
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && graph[nx][ny] == 0){
                    // 토마토가 있으면 +1
                    graph[nx][ny] = graph[cur[0]][cur[1]] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    public static int ans(){
        int answer = 0;

        for (int[] tomato : graph){
            int max = Arrays.stream(tomato).max().getAsInt();

            if (max > answer){
                answer = max -1;
            }

            for (int i = 0; i < tomato.length; i++) {
                if (tomato[i] == 0){
                    answer = -1;
                    // break 사용시 이중 반복문을 나갈 수 없음 -> 함수로 빼서 return 사용
                    return answer;
                }
            }
        }
        return answer;
    }
}