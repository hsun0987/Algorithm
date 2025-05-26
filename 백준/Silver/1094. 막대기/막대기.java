import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> list = new Stack<>();
        int X = Integer.parseInt(br.readLine());

        list.add(64);
        int sum = 64;

        while(true){
            if (sum == X){
                break;
            }
            sum = 0;
            // 1. 절반을 자르고 넣어
            int half = list.pop() / 2;
            list.add(half);
            // 2. 합을 구해
            for(int i : list){
                sum += i;
            }
            // 3. 합이 X보다 큰지 비교(작으면 절반 자른거 안버려)
            if(sum < X){
                list.add(half);
            }
        }

        int answer = list.size();
        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
}