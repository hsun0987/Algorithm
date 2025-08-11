import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        while (true){
            // 1. 첫번째 카드 제거
            bw.write(q.poll() + " ");

            // 마지막 카드일 경우
            if(q.isEmpty()){
                break;
            }

            // 2. 두번째 카드 맨 뒤로 이동
            q.add(q.poll());
        }

        bw.flush();
        bw.close();
    }
}