import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] input = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        int answer = 0;

        for (int i = 0; i < input.length; i++) {
            switch (input[i]){
                case '(':
                    stack.push('(');
                    break;
                case ')':
                    stack.pop();
                    if(input[i-1] == '('){
                        // 레이저
                        answer += stack.size();
                    }else{
                        // 막대기 끝
                        answer += 1;
                    }
                    break;
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
}