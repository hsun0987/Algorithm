import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        
        Stack<Character> stack = new Stack();

        for (char i : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().equals(i)) {
                stack.pop();
            } else {
                stack.push(i);
            }
        }

        answer = (stack.size() == 0) ? 1 : 0;

        return answer;
    }
}