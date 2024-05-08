import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> list = new LinkedList<>();

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        sb.append("<");
        while(true){
            if (list.size() == 1){
                break;
            }
            for (int i = 0; i < k; i++) {
                if(i == k-1){
                    sb.append(list.peek()).append(", ");
                    list.poll();
                    break;
                }
                list.add(list.poll());
            }
        }
        sb.append(list.peek());
        sb.append(">");
        System.out.println(sb);
    }
}