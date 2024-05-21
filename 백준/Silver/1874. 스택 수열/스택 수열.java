import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            q.add(Integer.parseInt(br.readLine()));
        }

        for (int i = 1; i < n+1; i++) {
            if(!stack.isEmpty()){
                while(!stack.isEmpty()){
                    int num = stack.pop();
                    if(num == q.peek()){
                        q.poll();
                        sb.append("- \n");
                    }else{
                        stack.push(num);
                        break;
                    }
                }
            }
            stack.push(i);
            sb.append( "+ \n");
        }

        int c = stack.size();
        for (int i = 0; i < c; i++) {
            int num = stack.pop();
            if(num == q.peek()){
                q.poll();
                sb.append("- \n");
            }else{
                stack.push(num);
            }
        }

        if(!stack.isEmpty()){
            System.out.println("NO");
        }else{
            System.out.println(sb);
        }
    }
}