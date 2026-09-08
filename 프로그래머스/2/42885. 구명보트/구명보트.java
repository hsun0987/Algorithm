import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
       int answer = 0;

        Arrays.sort(people);

        // 최소와 최대 무게 
        int start = 0;
        int end = people.length - 1;

        while (start <= end) {
            if (people[start] + people[end] <= limit) {
                // 두 명 탈 수 있는지
                answer += 1;
                start++;
                end--;
            } else {
                // 혼자 타야됨
                end--;
                answer += 1;
            }
        }
        return answer;
    }
}