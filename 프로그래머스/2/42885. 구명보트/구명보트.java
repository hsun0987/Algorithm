import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        // 1. 정렬
        Arrays.sort(people);
        // 2. 최소 몸무게 + 최대 몸무게 계산해서 보트에 태울 수 있는지?
        int start = 0;
        int end = people.length - 1;

        while(start <= end) {
            if ((people[start] + people[end]) > limit) {
                // 두명 합이 제한 무게보다 많이 나갈 때 -> 무거운 사람 보트 태우기
                end--;
            } else {
                // 두명 같이 보트에 태우기
                start++;
                end--;
            }
            answer++;
        }
        
        return answer;
    }
}