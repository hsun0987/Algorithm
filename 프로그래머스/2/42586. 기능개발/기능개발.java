import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> days = new LinkedList<>();

        // 1. 작업이 필요한 기간 계산
        for (int i = 0; i < progresses.length; i++) {
            int day = (int)Math.ceil((100 - progresses[i]) / (double)speeds[i]);
            // 2. 기간 큐에 저장
            days.add(day);
        }

        while(!days.isEmpty()){
            int now = days.remove();
            int count = 1;
            // 3. 앞선 작업 기간보다 값이 같거나 작으면 같이 pop
            while(!days.isEmpty() && now >= days.peek()){
                days.remove();
                count++;
            }
            // 4. count 해서 answer 에 저장
            answer.add(count);
        }
        
        return answer;
    }
}