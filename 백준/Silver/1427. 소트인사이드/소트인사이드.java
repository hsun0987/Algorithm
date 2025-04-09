import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 입력값을 잘라서 배열로 저장
        String[] arr = br.readLine().split("");
        // 2. 정렬
        Arrays.sort(arr);

        String answer = "";
        for (int i = arr.length-1; i >= 0; i--) {
            answer += arr[i];
        }

        bw.write(answer);
        bw.flush();
        bw.close();
    }
}