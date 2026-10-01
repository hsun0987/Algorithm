import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;

        Queue<Integer> q = new LinkedList<>();
        for (int i : order) {
            q.add(i);
        }
        Stack<Integer> stack = new Stack();

       for (int i = 1; i < order.length + 1; i++) {
            int current = q.peek();

            if (current == i) {
                q.poll();
                answer++;
            } else {
                // 스택 상위 = 큐 상위 같은지 확인(같을 때까지 반복)
                while(!stack.isEmpty() && stack.peek().equals(q.peek())) {
                    stack.pop();
                    q.poll();
                    answer++;
                }
                stack.push(i);

            }
        }

        while (!q.isEmpty() && !stack.isEmpty()) {
            if (q.peek().equals(stack.peek())) {
                q.poll();
                stack.pop();
                answer++;
            } else {
                break;
            }
        }
        return answer;
    }
}




