import java.util.*;

class Solution {
    public StringBuilder solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        
        // 1.앞자리부터 가능한 한 큰 숫자를 남긴다
        // 2. 뒤에 더 큰 숫자가 등장하면 앞의 작은 숫자를 제거한다
        
        int k2 = k;
        Stack<Character> stack = new Stack<>();
        for (char n : number.toCharArray()) {
            while (!stack.isEmpty() && stack.peek() < n && k2 > 0) {
                stack.pop();
                k2--;
            }

            stack.push(n);
        }
        
        // 반례 : 9, 8, 7, 6, 5
        while (k2 > 0) {
            stack.pop();
            k2--;
        }

        while (!stack.isEmpty()) {
            answer.append(stack.pop());
        }

        answer.reverse();

        return answer;
    }
}