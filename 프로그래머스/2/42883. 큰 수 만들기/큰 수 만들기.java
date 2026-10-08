import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";

        Stack<Character> stack = new Stack<>();

        for (char n : number.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() < n) {
                stack.pop();
                k--;
            }
            stack.push(n);
        }
        
        // 반례 : "98765"
        while (k > 0) {
            stack.pop();
            k--;
        }
        

        StringBuilder sb = new StringBuilder();
        
        for (char n : stack) {
            sb.append(n);
        }

        answer = sb.toString();
        
        return answer;
    }
}