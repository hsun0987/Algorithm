import java.util.*;

class Solution {
    public static long solution(int n, int[] times) {
        long answer = 0;

        // 이분탐색
        // 1. 시간 : 1 ~ 최대 시간
        // 2. sum = 중간값 / 심사대 걸리는 시간 당 처리 인원 수
        // 3. sum < n(총인원)

        // 걸리는 최소 시간
        
        Arrays.sort(times);


        long start = 1;
        long end =  (long) times[times.length - 1] * n;


        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;

            for (int i = 0; i < times.length; i++) {
                sum += mid / times[i];
                if (sum >= n)
                    break;
            }

            if (sum >= n) {
                answer = mid;
                end = mid - 1;

            } else {
                start = mid + 1;
            }
        }

        return answer;
    }
}