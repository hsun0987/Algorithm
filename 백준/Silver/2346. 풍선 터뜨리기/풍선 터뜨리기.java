import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<int[]> dq = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            dq.add(new int[]{i+1, Integer.parseInt(arr[i])});
        }

        // 1. 1번 풍선 터뜨리기
        // 2. 터뜨리고 나온 종이 만큼 인덱스 이동
        // -> 반복

        while(!dq.isEmpty()){
            // 처음 값 pop -> 번호 출력
            int[] now = dq.removeFirst();
            bw.write(now[0] + " ");
            // 적힌 숫자 만큼 회전
            if(now[1] > 0){
                Collections.rotate(dq, (now[1] - 1) * -1);
            }else{
                Collections.rotate(dq, now[1] * -1);
            }
        }
        bw.flush();
        bw.close();
    }
}