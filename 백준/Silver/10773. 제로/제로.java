import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            if(arr[i] == 0){
                stack.pop();
            }else{
                stack.push(arr[i]);
            }
        }

        int sum = 0;
        for (int i = 0; i < stack.size(); i++) {
            sum+= stack.get(i);
        }
        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }
}