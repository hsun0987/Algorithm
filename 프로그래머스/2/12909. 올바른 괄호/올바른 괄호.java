import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();

        for (char i : s.toCharArray()) {
            switch (i) {
                case '(':
                    stack.push(i);
                    break;
                case ')':
                    if (!stack.isEmpty()) {
                        stack.pop();
                        break;
                    } else {
                        // 반례 ")))" -> false
                        stack.push(i);
                    }
            }
        }

        answer = (stack.size() == 0) ? true : false;

        return answer;
    }
}