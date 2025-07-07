import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N][11]; // 0~10까지 만든다

        // N = 1일 때 다 1로 (인덱스 값으로는 0) 초기화
        for (int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 9; j >= 0; j--) {
                dp[i][j] = (dp[i-1][j]) % 10007 + (dp[i][j+1]) % 10007;
            }
        }


        long answer = 0;
        for (int i = 0; i < 10; i++) {
            answer = (answer +dp[N-1][i]) % 10007;
        }

        bw.write(answer % 10007 + "");
        bw.flush();
        bw.close();
    }
}