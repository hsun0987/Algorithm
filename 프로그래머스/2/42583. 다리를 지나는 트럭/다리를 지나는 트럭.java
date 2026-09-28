import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
                
          Queue<Integer> A = new LinkedList<>();
        for (int truck : truck_weights) {
            A.add(truck);
        }
       Queue<Integer> B = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            // 초기 다리 길이 만큼 0으로 채움
            B.add(0);
        }

        int sum = 0; // 트럭 무게
        while (!A.isEmpty() || sum > 0) {
            int out = B.poll();
            sum -= out;

            // 트럭 올리기
            if (!A.isEmpty() && (sum + A.peek()) <= weight) {
                int now = A.poll();
                B.add(now);
                sum += now;
            } else {
                B.add(0);
            }
            answer++;

        }
        return answer;
    }
}