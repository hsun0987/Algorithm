import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        // 1. dp 배열 생성 (int -> long)
        long[] dp = new long[n+1];
        // 2. 초기값 설정
        // 단, n < 2 일 경우 예외 처리
        if (n >= 1){
            dp[1] = 1;
        }

        for (int i = 2; i < n+1; i++) {
            // Fn = Fn-1 + Fn-2
            dp[i] = dp[i-1] + dp[i-2];
        }

        bw.write(dp[n] + "");

        bw.flush();
        bw.close();

    }
}