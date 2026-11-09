class Solution {
    boolean[] visited;
    int[][] computers;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        this.computers = computers;
        visited = new boolean[computers.length];
        
        for (int i = 0; i < computers.length; i++) {
            if(!visited[i]) {
                dfs(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    void dfs(int node) {
        visited[node] = true;
        
        for(int i = 0; i < computers.length; i++){
            if(!visited[i] && computers[node][i] == 1) {
                dfs(i);
            }
        }
    }
}


