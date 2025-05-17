import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        // 이분탐색
        // start = 최초시작(1ms), end = 최악의 시간(max * 인원수)
        // mid = (start+end) / 2
        // 각 mid 시간 동안 처리할 수 있는 사람(몫) 의 합
        // 합 > total => 시간 넉넉 -> 더 최소 시간 구함(왼쪽 탐색)

        // times 정렬
        Arrays.sort(times);

        long start = 1;
        long end = (long) times[times.length - 1] * n;

        while(start <= end){
            long mid = (start + end) / 2;

            long sum = 0;
            for(int t : times){
                sum += mid / t;
                // 인원 수가 넘어가면 계산 중단
                if (sum >= n) break;
            }

            // 왼쪽 탐색
            if(sum >= n){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        // 시작값이 최소니까
        answer = start;
        
        return answer;
    }
}