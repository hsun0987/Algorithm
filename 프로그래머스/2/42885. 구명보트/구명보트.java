import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        // 정렬
        Arrays.sort(people);
        
        // 가장 가벼운 사람 + 가장 무거운 사람 <= limit
        // answer++ start++, end--
        // limit 보다 크면 무거운 사람만 태우기 
        // answer++ end-- 
        
        int start = 0;
        int end = people.length - 1;
        
        while(start <= end) {
            if((people[start] + people[end]) <= limit) {
                start++;
                end--;
            } else {
                end--;
            }
            answer++;
        }
        
        return answer;
    }
}