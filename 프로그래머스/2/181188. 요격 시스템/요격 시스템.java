import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 1;
        
        Arrays.sort(targets, (a, b) -> a[1] - b[1]);
        
        int temp = targets[0][1];
        
        for (int[] t : targets) {
            if(temp <= t[0]) {
                answer++;
                temp = t[1];
            }
        }
           
        return answer;
    }
}

