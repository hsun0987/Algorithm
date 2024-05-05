import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack;
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            stack = new Stack<>();
            String s = sc.next();

            for (int j = 0; j < s.length(); j++) {
                if(s.charAt(j) == '(' || stack.empty()){
                    stack.push(s.charAt(j));
                } else if (!stack.empty() && s.charAt(j) == ')') {
                    if(stack.peek() == '('){
                        stack.pop();
                    }
                }
            }
            if (!stack.empty()){
                sb.append("NO").append('\n');
            }else{
                sb.append("YES").append('\n');
            }
        }

        System.out.println(sb);
    }
}