import java.util.*;
class Solution {
    public Deque solution(int[] numbers, String direction) {
        Deque<Integer> answer;
        // 덱큐 사용
        Deque <Integer> deque = new LinkedList<>();
        
        for (int i : numbers) {
            deque.addLast(i);
        }
        
        if (direction.equals("right")) {
            deque.addFirst(deque.pollLast());
        } else {
            deque.addLast(deque.pollFirst());
        }
        
        answer = deque;
        return answer;
    }
}