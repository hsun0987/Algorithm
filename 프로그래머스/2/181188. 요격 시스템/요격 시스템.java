import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 1;

        Arrays.sort(targets, (a, b) -> a[1] - b[1]);
        
        // 가장 작은 e를 기준
        int temp = targets[0][1];

        // 단, s/e 지점에는 발사 X
        for (int[] t : targets) {
            if (t[0] >= temp) {
                answer++;
                temp = t[1];
            }
        }
        
        return answer;
    }
}