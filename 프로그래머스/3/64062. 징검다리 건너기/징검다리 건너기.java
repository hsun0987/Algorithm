import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;

        long start = 1;
        long end = Arrays.stream(stones).max().getAsInt();

        while(start <= end) {
            long mid = (start + end) / 2;

            int cnt = 0; // 연속된 0의 개수
            boolean possible = true;
            for (int s : stones) {
                if ((s - mid) < 0) {
                    cnt ++;

                    if (cnt == k) {
                        possible = false;
                        break;
                    }
                } else {
                    cnt = 0;
                }
            }


            if (possible) {
                start = mid + 1;
                answer = (int)mid;
            } else {
                end = mid - 1;
            }
        }

        return answer;
    }
}

