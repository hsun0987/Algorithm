import java.util.*;

class Solution {
    boolean[][] visited;
    int[][] maps;
    int n, m;

    // 상하좌우
    int[] dy = {-1, 1, 0, 0};
    int[] dx = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        this.maps = maps;
        this.n = maps.length;
        this.m = maps[0].length;

        this.visited = new boolean[n][m];

        answer = bfs(0, 0);
        
        
        
        return answer;
    }
    
    public int bfs(int y, int x) {       
        Queue<int[]> q = new LinkedList<>();
        
        // 1. 방문 표시
        visited[y][x] = true;
        // 2. 현재 위치 큐에 넣기
        q.add(new int[]{y, x, 0});


        // 큐에 데이터가 있을 때까지 반복
        while(!q.isEmpty()){
            // 큐에서 꺼내기
            int[] current = q.poll();
            int cy = current[0];
            int cx = current[1];
            int depth = current[2];

            if (cy == n-1 && cx == m-1){
                return depth + 1;
            }

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
                    // 2. 방문 여부 체크
                    if (!visited[ny][nx] && maps[ny][nx] != 0) {
                        // 3. 방문x, 벽이 아니면 큐에 담기
                        // 방문 표시
                        visited[ny][nx] = true;
                        q.add(new int[]{ny, nx, depth + 1});
                    }
                }
            }
        }

        return -1;
    }
}