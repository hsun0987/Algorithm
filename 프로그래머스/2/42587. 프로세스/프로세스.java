import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        // 우선 순위 큐 이용
        PriorityQueue <Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < priorities.length; i++) {
            queue.add(priorities[i]);
        }

        while (!queue.isEmpty()){
            for (int i = 0; i < priorities.length; i++) {
                // 현재 프로세스가 우선순위 큐랑 같은지 비교
                if(priorities[i] == queue.peek()){
                    // 알고싶은 프로세의 위치가 같을 때 return
                    if(i == location){
                        answer++;
                        return answer;
                    }
                    // answer(순서) 누적
                    answer++;
                    //한번 실행한 프로세스는 제거
                    queue.remove();
                }
            }
        }
        
        return answer;
    }
}