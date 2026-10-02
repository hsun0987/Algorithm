import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        // 뒷큰수 : 자신보다 뒤에 있는 숫자 중 크면서 가장 가까운 수
        Stack<Integer> stack = new Stack<>(); // numbers 인덱스 번호

        for (int i = 0; i < numbers.length; i++) {
            // 스택 상위 < 현재 숫자
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }
        
        return answer;
    }
}