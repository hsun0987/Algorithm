import java.util.*;

class Solution{
    public int solution(String s){
        int answer = 1;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            // 1. 스택 비어있거나 다음 문자랑 다르면 push
            if (stack.empty() || stack.peek() != s.charAt((i))) {
                stack.push(s.charAt(i));
            }else{
                // 2. top이랑 다음 문자랑 같으면 제거
                stack.pop();
            }
        }
        
        // 3. 최종 스택이 비어있으면 성공 -> 1
        //     x  실패 -> 0
        if (!stack.empty()) {
            answer = 0;
        }

        return answer;
    }
}