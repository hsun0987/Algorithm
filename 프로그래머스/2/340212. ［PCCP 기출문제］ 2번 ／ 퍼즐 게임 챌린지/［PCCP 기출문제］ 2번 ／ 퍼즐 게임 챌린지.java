import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;

        // start, end -> level의 최소 최대 범위
        int start = 1; // 숙련도 양의 정수(1부터 시작)
        int end = Arrays.stream(diffs).max().getAsInt(); // 난이도의 최댓값

        while(start <= end) {
            int mid = (start + end) / 2;

            // 총 걸린 시간 구하기
            long sum = 0;

            for (int i = 0; i < diffs.length; i++) {
                if (i > 0 && diffs[i] > mid) {
                    sum += (long)(diffs[i] - mid) * (times[i] + times[i-1]) + times[i];
                } else {
                    sum += times[i];
                }
            }

            if (sum <= limit) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }

        return answer;
    }
}