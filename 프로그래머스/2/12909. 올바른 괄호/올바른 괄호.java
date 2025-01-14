import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        // 1. ( 이 괄호가 나오면 스택에 넣고
        // 2. ) 이 괄호가 나오면 스택에서 뺌
        // - 스택에 ) 이거로 시작하면 false
        // - ) 이 괄호가 없는데 문자가 끝나면 false

        Stack <Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                stack.push(s.charAt(i));
            }
            else {
                if(stack.isEmpty()){
                    answer = false;
                    break;
                } else {
                    stack.pop();
                }
            }
        }
        if(!stack.isEmpty())
            answer = false;
        
        return answer;
    }
}