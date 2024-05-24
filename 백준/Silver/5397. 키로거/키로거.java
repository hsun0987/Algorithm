import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        Stack<Character> stack = new Stack<>();
        Stack<Character> imsy = new Stack<>();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            sb = new StringBuilder();
            char[] pw = br.readLine().toCharArray();
            for (int j = 0; j < pw.length; j++) {
                switch (pw[j]){
                    // 백스페이스
                    case '-':
                        if(!stack.isEmpty()){
                            stack.pop();
                        }
                        break;
                    // 화살표 이동
                    case '<':
                        if (!stack.isEmpty()){
                            imsy.push(stack.pop());
                        }
                        break;
                    case '>':
                        if(!imsy.isEmpty()){
                            stack.push(imsy.pop());
                        }
                        break;
                    default:
                        stack.push(pw[j]);
                        break;
                }
            }
            while(!imsy.isEmpty()){
                stack.push(imsy.pop());
            }

            int len = stack.size();
            for (int k = 0; k < len; k++) {
                sb.append(stack.pop());
            }
            sb.reverse();
            System.out.println(sb);
        }
    }
}