import java.util.*;

class Solution {
    char[][] graph;
    boolean[][] visited;
    int N, M;

    class Current {
        int[] xy;
        int cnt;

        Current(int[] xy, int cnt) {
            this.xy = xy;
            this.cnt = cnt;
        }
    }

    int[] dx = {0,0,-1,1};
    int[] dy = {1,-1,0,0};

    public int solution(String[] board) {
        int answer = 0;

        N = board.length;
        M = board[0].length();

        graph = new char[N][M];

        int[] R = new int[1];
        for (int i = 0; i < board.length; i++) {
            graph[i] = board[i].toCharArray();

            // R의 위치 찾기
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] == 'R') {
                    R = new int[]{i, j};
                }
            }
        }

        visited = new boolean[N][M];
        answer = bfs(new Current(R, 0));

        return answer;
    }

    int bfs(Current R) {
        Queue<Current> q = new LinkedList<>();
        q.add(R);
        visited[R.xy[0]][R.xy[1]] = true; // 방문처리

        while (!q.isEmpty()){
            Current current = q.poll();
            int y = current.xy[0];
            int x = current.xy[1];
            int cnt = current.cnt;

            // 정지 위치
            if (graph[y][x] == 'G') {
                return cnt;
            }

            // 상하좌우
            for (int i = 0; i < 4; i++) {
                // 다음 칸 계산
                int ny = y + dy[i];
                int nx = x + dx[i];

                // 상하좌우 한방향으로 한칸 이동(반복문)
                while (true) {
                    // 이동 가능한 범위인지
                    if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                        // 다음 위치가 D 인 경우
                         if (graph[ny][nx] == 'D') {
                            // 방문여부 = 정지 위치(장애물 전칸) -> 방문 X만 큐에 넣음
                            if (!visited[ny-dy[i]][nx-dx[i]]) {
                                q.add(new Current(new int[]{ny-dy[i], nx-dx[i]}, cnt + 1));
                                visited[ny-dy[i]][nx-dx[i]] = true;
                            }
                            break;
                        }
                        // 같은 방향으로 한칸 이동
                        ny += dy[i];
                        nx += dx[i];

                    } else { // 범위 밖 = 정지 위치
                        if (!visited[ny-dy[i]][nx-dx[i]]) {
                            q.add(new Current(new int[]{ny-dy[i], nx-dx[i]}, cnt + 1));
                            visited[ny-dy[i]][nx-dx[i]] = true;
                        }
                        break;
                    }
                }
            }
        }

        return -1;
    }

}