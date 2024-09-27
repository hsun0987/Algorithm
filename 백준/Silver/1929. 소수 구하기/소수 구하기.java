import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 에라토스테네스의 체 이용
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 1. 배열 생성
        int[] arr = new int[m+1];
        for (int i = 2; i < m+1; i++) {
            arr[i] = i;
        }

        // 2. 특정 수의 배수에 해당하는 수 지우기
        for (int i = 2; i < m+1 ; i++) {
            if (arr[i] == 0)
                continue;

            // 지워진 수가 아닐 경우 그 배수부터 가능한 모든 배수 지우기
            for (int j = 2*i; j < m+1 ; j += i) {
                arr[j] = 0;
            }
        }

        //3. 남아있는 수 출력 => 특정 범위 내만
        for (int i = n; i < m+1; i++) {
            if (arr[i] != 0)
                bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
}