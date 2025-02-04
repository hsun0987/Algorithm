import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        // 1. 정렬
        // 2. h번 인용된 논문이 h편 이상인 h 구하기
        // - h보다 큰 값이 h개가 있는 것을 찾기
        // max(f(i) >= i)
        
        Integer[] reverse = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(reverse, Collections.reverseOrder());

        for(int i = 0; i < citations.length; i++){
            if(reverse[i] >= i + 1)
                answer = i + 1;
        }
        return answer;
    }
}