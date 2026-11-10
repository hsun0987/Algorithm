import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int start = 0;
        int end = people.length - 1;
        
        while(start <= end) {
           
            int sum = people[start] + people[end];
            
            if(sum <= limit) { // 가장 가볍 + 무겁 같이 보트 태움
                start++;
                end--;
            } else { // 무거운 사람만 보트 태움
                end--;
            }
            
            answer++;
        }
        
        return answer;
    }
}
