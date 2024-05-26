import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 레이저를 쏘면 스택의 사이즈 만큼 더해준다 = 레이저를 쏘고 나눠진 조각 수
        // 2. 막대가 끝나면 +1 = 레이저를 쏜 다음 남은 1조각
        Stack<Character> stack = new Stack<>();
        int answer = 0;

        char[] input = br.readLine().toCharArray();
        for (int i = 0; i < input.length; i++) {
            if(input[i] == '('){
                stack.push(input[i]);
            }else{
                stack.pop();
                if(input[i-1] == '('){
                    answer += stack.size();
                }else{
                    answer += 1;
                }
            }
        }
        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
}