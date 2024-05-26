import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 연산자를 우선순위로 저장
        HashMap<Character, Integer> map = new HashMap<>(){
            {
                put('(', 0);
                put(')', 0);
                put('*', 1);
                put('/', 1);
                put('+', 2);
                put('-', 2);
            }
        };

        Stack<Character> stack = new Stack<>();
        char[] input = br.readLine().toCharArray();

        for (int i = 0; i < input.length; i++) {
            // 연산자나 괄호가 아닐 경우
            if(!map.containsKey(input[i])){
                bw.write(input[i] + "");
            } else {
                if (stack.isEmpty()) {
                    stack.push(input[i]);
                    continue;
                }

                if (input[i] == ')') {
                    while (stack.peek() != '(') {
                        bw.write(stack.pop());
                    }
                    // ( 괄호도 제거
                    stack.pop();
                } else if (map.get(stack.peek()) <= map.get(input[i]) && map.get(stack.peek()) != 0) {
                    // 연산자가 우선순위가 높기 때문에 먼저 빼줌 (괄호는 제외해야됨)
                    if(input[i] != '('){
                        bw.write(stack.pop());
                        if(map.get(input[i]) > 1){
                            // + - 일때
                            while(!stack.isEmpty() && stack.peek() != '(')
                                bw.write(stack.pop());
                        }
                    }
                }
                if (input[i] != ')') {
                    stack.push(input[i]);
                }
            }
        }

        int len = stack.size();
        if(!stack.isEmpty()){
            for (int i = 0; i < len; i++) {
                bw.write(stack.pop());
            }
        }

        bw.flush();
        bw.close();
    }
}