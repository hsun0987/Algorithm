import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();


        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            String command = in.next();

            if (command.equals("push")) {
                int num = in.nextInt();
                stack.push(num);
            } else if (command.equals("top")) {
                if (stack.empty()){
                    sb.append("-1").append('\n');
                    continue;
                }
                sb.append(stack.peek()).append('\n');
            } else if (command.equals("size")) {
                sb.append(stack.size()).append('\n');
            } else if (command.equals("empty")) {
                if (stack.isEmpty()){
                    sb.append("1").append('\n');
                }else
                    sb.append("0").append('\n');
            } else if (command.equals("pop")) {
                if (stack.empty()){
                    sb.append("-1").append('\n');
                    continue;
                }
                sb.append(stack.pop()).append('\n');
            }
        }
        System.out.println(sb);
    }
}