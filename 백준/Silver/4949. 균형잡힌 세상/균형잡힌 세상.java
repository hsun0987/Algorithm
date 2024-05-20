import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack;

        while(true){
            String str = br.readLine();
            if(str.charAt(0) == '.' && str.length() == 1){
                break;
            }
            stack = new Stack<>();
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == '(' || str.charAt(i) == '['){
                    stack.push(str.charAt(i));
                }
                if(!stack.isEmpty()){
                    if(str.charAt(i) == ')') {
                        if(stack.peek() == '('){
                            stack.pop();
                        }else {
                            stack.push(str.charAt(i));
                        }
                    } else if(str.charAt(i) == ']'){
                        if(stack.peek() == '['){
                            stack.pop();
                        }else {
                            stack.push(str.charAt(i));
                        }
                    }
                }else{
                    if(str.charAt(i) == ')' || str.charAt(i) == ']'){
                        stack.push(str.charAt(i));
                    }
                }
            }
            if(stack.isEmpty()){
                bw.write("yes \n");
            }else{
                bw.write("no \n");
            }
        }

        bw.flush();
        bw.close();
    }
}