import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int[] dp = new int[y+1];
        Arrays.fill(dp, Integer.MAX_VALUE); // 최댓값으로 세팅
        dp[x] = 0; // 시작 값만 0으로
        
        for (int i = x; i < y+1; i++) {
            // 도달하지 않은 값은 건너뛰기
            if(i != x && dp[i] == Integer.MAX_VALUE) continue;
            
            // +n, *2, *3 위치에서 갯수 최솟값을 저장
            if(i+n <= y) dp[i+n] = Math.min(dp[i+n], dp[i] + 1);
            if(i*2 <= y) dp[i*2] = Math.min(dp[i*2], dp[i] + 1);
            if(i*3 <= y) dp[i*3] = Math.min(dp[i*3], dp[i] + 1);
        }
        
        int answer = (dp[y] == Integer.MAX_VALUE)? -1 : dp[y];
        return answer;
    }
}



