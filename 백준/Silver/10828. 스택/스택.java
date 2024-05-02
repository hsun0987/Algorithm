import java.util.LinkedList;
import java.util.Queue;
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

            switch (command) {
                case "push":
                    int num = in.nextInt();
                    stack.push(num);
                    break;
                case "top":
                    if (stack.isEmpty()) {
                        sb.append("-1").append('\n');
                        break;
                    }
                    sb.append(stack.peek()).append('\n');
                    break;
                case "size":
                    sb.append(stack.size()).append('\n');
                    break;
                case "empty":
                    if (stack.isEmpty()) {
                        sb.append("1").append('\n');
                    } else
                        sb.append("0").append('\n');
                    break;
                case "pop":
                    if (stack.isEmpty()) {
                        sb.append("-1").append('\n');
                        break;
                    }
                    sb.append(stack.pop()).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }
}