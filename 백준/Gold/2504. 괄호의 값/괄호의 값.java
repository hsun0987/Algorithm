import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack = new Stack<>();

        // (,[ 괄호일 때 *2, *3
        // ),] 괄호일 때 /2, /3 -> 괄호가 닫혔을 때 곱셈을 초기화해줌
        // 괄호가 닫혔을 때(곱셈 계산이 끝남) 곱셈한 결과를 이전 괄호 값에 더해줌

        // 곱셈 계산 저장할 변수
        int imsy = 1;
        int answer = 0;

        char[] input = br.readLine().toCharArray();
        for (int i = 0; i < input.length; i++) {
            switch (input[i]){
                case '(':
                    stack.push(input[i]);
                    imsy *= 2;
                    break;
                case ')':
                    if (!stack.empty() && stack.peek() == '('){
                        if (input[i-1] == '(') {
                            // input의 괄호가 () 이 형태일 때 최종 계산 => input의 이전 값 확인
                            answer += imsy;
                            imsy /= 2;
                            stack.pop();
                        } else{
                            imsy /= 2;
                            stack.pop();
                        }
                    }else{
                        System.out.println("0");
                        return;
                    }
                    break;
                case '[':
                    stack.push(input[i]);
                    imsy *= 3;
                    break;
                case ']':
                     if (!stack.empty() && stack.peek() == '['){
                         if (input[i-1] == '[') {
                             answer += imsy;
                             imsy /= 3;
                             stack.pop();
                         } else{
                             imsy /= 3;
                             stack.pop();
                         }
                     }else{
                         System.out.println("0");
                         return;
                     }
                    break;
            }
        }
        if(imsy != 1){
            answer = 0;
        }
        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
}