import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> arr = new LinkedList<>();

        int input = Integer.parseInt(br.readLine());
        for (int i = 1; i <= input; i++) {
            arr.add(i);
        }

        while(arr.size() > 1){
            arr.poll(); // 1 제거
            arr.add(arr.peek()); // 2 뒤에 추가
            arr.poll(); // 2 제거
        }

        bw.write( arr.peek() + "\n");
        bw.flush();
        bw.close();
    }
}