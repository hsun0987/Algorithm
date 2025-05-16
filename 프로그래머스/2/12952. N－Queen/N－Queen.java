class Solution {
    boolean[] col;
    boolean[] dae1; // row + col
    boolean[] dae2; // row - col
    int answer;
    
    public int solution(int n) {
        answer = 0;
        
        // 가로, 세로, 대각선 모두 겹치면 안됨
        // 한 행에 1개만 있어야함
        // 개수 = n 이 되면 끝
        
        col = new boolean[n];
        dae1 = new boolean[n * 2];
        dae2 = new boolean[n * 2];
        // 행 단위
        dfs(0, n);
    
        return answer;
    }
    
    void dfs(int row, int n){
        // 모든 행에 말을 뒀으면(n개를 다 놓은 경우 => 답++)
        if(row == n){
            answer++;
            return;
        }
        
        for(int i = 0; i < n; i++){
            // 같은 열, 대각선 포함x 
            if(!col[i] && !dae1[row + i] & !dae2[row - i + n]){
                col[i] = true;
                dae1[row + i] = true;
                dae2[row - i + n] = true;
                
                dfs(row + 1, n);
                
                // 재탐색을 위해
                col[i] = false;
                dae1[row + i] = false;
                dae2[row - i + n] = false;
            }
        }
    }
}