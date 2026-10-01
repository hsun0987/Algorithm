import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;

        Queue<Integer> q = new LinkedList<>(); // 기존 컨테이너
        Stack<Integer> stack = new Stack(); // 보조 컨테이너

        // 현재 상자 순서 인덱스
        int cnt = 0;

        // 택배상자 이동 1~N
        for (int i = 1; i < order.length + 1; i++) {
            stack.push(i);

            while(!stack.isEmpty()) {
                if (stack.peek().equals(order[cnt])) {
                    // 보조 -> 기존 옮김
                    q.add(stack.pop());
                    cnt++;
                } else {
                    break;
                }
            }
        }

        // 기존 컨테이너에 담긴 개수
        answer = q.size();
        return answer;
    }
}




