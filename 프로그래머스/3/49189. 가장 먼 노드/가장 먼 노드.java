import java.util.*;

class Solution {
    static boolean[][] graph;
    static boolean[] visited;
    static int[] depth;
    static Queue<Integer> q = new LinkedList<>();
    
    public static void bfs(int n, int idx){
        // 1. 큐에 값 추가 후 방문 체크
        q.add(idx);
        visited[idx] = true;

        while(!q.isEmpty()){
            // 2. 큐에서 처음 값 pop
            int cur = q.poll();
            for (int i = 1; i <= n; i++) {
                // 3. 방문 x 연결된 노드 값 큐에 담기
                if (!visited[i] && graph[cur][i]){
                    q.add(i);
                    visited[i] = true;
                    // 4. 거리 값 저장(처음 값의 depth + 1)
                    depth[i] = depth[cur] + 1;
                }
            }
        }
    }
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        graph = new boolean[n+1][n+1];
        visited = new boolean[n+1];
        depth = new int[n+1];

        // 1. 그래프화
        for (int[] i : edge) {
            int x = i[0];
            int y = i[1];

            graph[x][y] = graph[y][x] = true;
        }

        // 2. bfs
        bfs(n, 1);

        // 3. 가장 먼 노드의 개수
        int max = Arrays.stream(depth).max().getAsInt();
        for (int i : depth) {
            if (i == max){
                answer++;
            }
        }
        
        return answer;
    }
}