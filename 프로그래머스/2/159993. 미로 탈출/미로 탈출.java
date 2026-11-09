import java.util.*;
class Solution {
    
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};
    
    boolean[][][] visited;
    char[][] graph;
    
    class Current {
        int[] xy;
        int cnt;
        boolean label;
        
        Current() {}
        
        
        Current(int[] xy, int cnt, boolean label) {
            this.xy = xy;
            this.cnt = cnt;
            this.label = label;
        }
    }
    
    
    public int solution(String[] maps) {
        int answer = 0;
        
        visited = new boolean[maps.length][maps[0].length()][2];
        graph = new char[maps.length][maps[0].length()];
        
        // start 지점 찾기
        Current start = new Current();
        
        for(int i = 0; i < maps.length; i++) {
            graph[i] = maps[i].toCharArray();
            
            for(int j = 0; j < graph[i].length; j++) {
                if(graph[i][j] == 'S') {
                    start.xy = new int[]{i, j};
                    start.cnt = 0;
                    start.label = false;
                }
            }
        }
        
        answer = bfs(start);
        
        return answer;
    }
    
    int bfs(Current start) {
        int[] xy = start.xy;      
        Queue<Current> q = new LinkedList<>();
        q.add(start);
        visited[xy[0]][xy[1]][0] = true;
        
        while(!q.isEmpty()) {
            Current cur = q.poll();
            int cy = cur.xy[0];
            int cx = cur.xy[1];
            int cnt = cur.cnt;
            boolean label = cur.label;
            
            
            // E 인 경우 레버 on 확인 
            if(graph[cy][cx] == 'E' && label) {
                return cnt;
            }
            
            // 이동 조건 못하는 조건 : X이거나 범위 밖
            // 이동 조건 : S, E, L, O, 범위 안, 방문 전 
            // L 인 경우 레버 on -> visited 레버 당긴 이후
            
            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                
                if(nx >= 0 && nx < graph[0].length && ny >= 0 && ny < graph.length) {                    
                    // 현재 상태가 true면 1, false면 0
                    int state = label ? 1 : 0;
                    
                    if(graph[ny][nx] != 'X' && !visited[ny][nx][state]) {
                        visited[ny][nx][state] = true;
                        if (graph[ny][nx] == 'L') {
                            visited[ny][nx][1] = true;
                            q.add(new Current(new int[]{ny, nx}, cnt + 1, true));
                        } else {
                           q.add(new Current(new int[]{ny, nx}, cnt + 1, label));
                        }
                    }
                }
            }
        }

        return -1;
    }
}


