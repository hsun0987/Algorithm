import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        // 1. 각 작업일 구하기
        // 2. 앞에 수보다 작으면 같이 빼기 -> 큐
        // 3. 처리된 갯수 answer 에 저장 
        
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int a = 100 - progresses[i];
            int b = a/speeds[i] + (a%speeds[i] != 0? 1:0);
            q.add(b);
        }

        ArrayList<Integer> arr = new ArrayList<>();
        while (!q.isEmpty()) {
            int now = q.poll();
            int cnt = 1;
            while (!q.isEmpty() && now >= q.peek()) {
                q.poll();
                cnt++;
            }
            arr.add(cnt);
        }

        answer = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        
        return answer;
    }
}