import java.util.*;

class Solution {
    class Process {
        int index;
        int priority;
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        // location 을 어떻게 기억할지?
        // -> 인덱스 번호도 함께 큐에 저장
        // 1. 우선순위 큐의 순위와 다를 경우 큐 뒤로 이동
        // 2. 같을 경우 실행 + 카운트 업
        // 3. 현재 인덱스가 location 과 같으면 끝

        Queue<Process> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < priorities.length; i++) {
            Process process = new Process();
            process.index = i;
            process.priority = priorities[i];
            q.add(process);
            pq.add(priorities[i]);
        }

        while (!q.isEmpty()) {
            int np = pq.peek();

            // 1. 현재 대기 중인 큐의 첫번째의 우선순위 확인
            Process current = q.poll();

            // 2. 우선순위가 pq와 같으면 실행 / 다르면 뒤로 다시 넣기
            if (np != current.priority) {
                q.add(current);
            } else {
                answer++; // 실행 시 카운트업
                pq.poll();

                if (current.index == location) {
                    break;
                }
            }  
        }
        return answer;
    }
}