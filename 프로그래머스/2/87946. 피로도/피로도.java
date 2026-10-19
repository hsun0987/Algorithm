import java.util.*;
class Solution {
    
    int k;
    int[][] dungeons;
    boolean[] visited;
    int answer;
    
    public int solution(int k, int[][] dungeons) {
        this.k = k;
        this.dungeons = dungeons;
        this.visited = new boolean[dungeons.length];
        this.answer = 0;

        dfs(0, k);
        
        return answer;
    }
    
    void dfs(int depth, int K) {
        answer = Math.max(answer, depth);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && K >= dungeons[i][0]) {
                visited[i] = true;
                dfs(depth+1, K -dungeons[i][1]);
                visited[i] = false;
            }
        }
    }
}