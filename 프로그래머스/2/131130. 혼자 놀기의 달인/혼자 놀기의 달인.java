import java.util.*;

class Solution {
    boolean[] visited;
    int[] cards;
    int n;
    
    public int solution(int[] cards) {
        int answer = 0;
        
        n = cards.length;
        visited = new boolean[n+1];
        this.cards = cards;
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            if(!visited[i+1]) { 
                int cnt = dfs(i+1);                
                list.add(cnt);
            }
        }
        
        list.sort(Comparator.reverseOrder()); 
        if(list.size() > 1) {
            answer = list.get(0) * list.get(1);
        }
        
        return answer;
    }
    
    int dfs(int idx) {
        visited[idx] = true;
        
        int cnt = 1;
        
        // 1상자 -> 1카드
        if(!visited[cards[idx-1]]) {
            cnt += dfs(cards[idx-1]);
        }
        
        return cnt;
    }
}
