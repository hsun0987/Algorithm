import java.util.*;

class Solution {
     String[] maps;
    char[][] graph;
    boolean[][][] visited;

    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};

    class Current {
        int[] xy;
        int cnt;
        boolean L = false;

        Current() {};

        Current(int[] xy, int cnt, boolean L) {
            this.xy = xy;
            this.cnt = cnt;
            this.L = L;
        }
    }

    public int solution(String[] maps) {
        int answer = 0;
        this.maps = maps;

        graph = new char[maps.length][maps[0].length()];
        Current start = new Current();
        for (int i = 0; i < maps.length; i++) {
            graph[i] = maps[i].toCharArray();

            // start 위치 찾기
            for (int j = 0; j < maps[i].length(); j++) {
                if (graph[i][j] == 'S') {
                    start.xy = new int[]{i, j};
                    start.cnt = 0;
                }
            }
        }

        visited = new boolean[graph.length][graph[0].length][2];
        answer = bfs(start);

        return answer;
    }

    int bfs(Current start) {
        int sy = start.xy[0];
        int sx = start.xy[1];
        // 방문 표시
        visited[sy][sx][0] = true;
        // 큐에 넣기
        Queue<Current> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            Current current = q.poll();
            int cy = current.xy[0];
            int cx = current.xy[1];
            int cnt = current.cnt;
            boolean L = current.L;

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny >= 0 && ny < graph.length && nx >= 0 && nx < graph[0].length) {
                    // o & 방문 x -> 큐에 넣기
                    // 레버 당기기 전 방문
                    if (!L && !visited[ny][nx][0]) {
                        // 출발지점도 다시 지나갈 수 있음 !!
                        if (graph[ny][nx] == 'O' || graph[ny][nx] == 'E' || graph[ny][nx] == 'S') {
                            visited[ny][nx][0] = true;
                            q.add(new Current(new int[]{ny,nx}, cnt+1, false));
                        } else if (graph[ny][nx] == 'L') {
                            visited[ny][nx][1] = true;
                            q.add(new Current(new int[]{ny,nx}, cnt+1, true));
                        }
                    } else if (L && !visited[ny][nx][1]){ // 레버 오픈 후 방문 여부
                        if (graph[ny][nx] == 'O' || graph[ny][nx] == 'L' || graph[ny][nx] == 'S') {
                            visited[ny][nx][1] = true;
                            q.add(new Current(new int[]{ny,nx}, cnt+1, true));
                        } else if (graph[ny][nx] == 'E') {
                            return cnt + 1;
                        }
                    }
                }
            }
        }
        return -1;
    }

}
