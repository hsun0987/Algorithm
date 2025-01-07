import java.util.*;

public class Solution {
    public Stack<Integer> solution(int []arr) {
        // 연속적으로 나타나는 숫자 제거
        // - 스택에 하나씩 push
        // - 상위 peek 했을 때 같은게 있으면 continue

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if(! stack.empty() && stack.peek() == arr[i])
                continue;
            stack.push(arr[i]);
        }
        
        return stack;
    }
}