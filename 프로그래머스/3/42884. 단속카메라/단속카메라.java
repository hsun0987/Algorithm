import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;

        Arrays.sort(routes, (a, b) -> a[1] - b[1]);

        // 가장 빨리 나가는 차량 진출 시점
        int now = routes[0][1];
        for (int[] r : routes) {
            if (r[0] > now) {
                answer++;
                now = r[1];
            }
        }
        
        return answer;
    }
}