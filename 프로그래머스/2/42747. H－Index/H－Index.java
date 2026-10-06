import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            // 현재 위치부터 남은 논문 수
            int h = citations.length - i;
            // 현재 위치부터 뒤의 논문 h편이 모두 h번 이상 인용된 것
            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }
        
        return answer;
    }
}