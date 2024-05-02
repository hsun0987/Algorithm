import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Queue<Integer> stack = new LinkedList<>();

        int t = in.nextInt();
        int rear = 0;
        for (int i = 0; i < t; i++) {
            String command = in.next();

            switch (command) {
                case "push":
                    int num = in.nextInt();
                    stack.add(num);
                    rear = num;
                    break;
                case "front":
                    if (stack.isEmpty()) {
                        sb.append("-1").append('\n');
                        break;
                    }
                    sb.append(stack.peek()).append('\n');
                    break;
                case "back":
                    if (stack.isEmpty()) {
                        sb.append("-1").append('\n');
                        break;
                    }
                    sb.append(rear).append('\n');
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
                    sb.append(stack.remove()).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }
}