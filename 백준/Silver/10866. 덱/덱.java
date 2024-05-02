import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Deque<Integer> stack = new LinkedList<>();

        int t = in.nextInt();
        int num;

        for (int i = 0; i < t; i++) {
            String command = in.next();

            switch (command) {
                case "push_front":
                    num = in.nextInt();
                    stack.addFirst(num);
                    break;
                case "push_back":
                    num = in.nextInt();
                    stack.addLast(num);
                    break;
                case "front":
                    if (stack.isEmpty()) {
                        sb.append("-1").append('\n');
                        break;
                    }
                    sb.append(stack.getFirst()).append('\n');
                    break;
                case "back":
                    if (stack.isEmpty()) {
                        sb.append("-1").append('\n');
                        break;
                    }
                    sb.append(stack.getLast()).append('\n');
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
                case "pop_front":
                    if (stack.isEmpty()) {
                        sb.append("-1").append('\n');
                        break;
                    }
                    sb.append(stack.removeFirst()).append('\n');
                    break;
                case "pop_back":
                    if (stack.isEmpty()) {
                        sb.append("-1").append('\n');
                        break;
                    }
                    sb.append(stack.removeLast()).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }
}