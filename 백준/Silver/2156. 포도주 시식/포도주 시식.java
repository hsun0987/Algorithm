import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());
        int[] wine = new int[N+1];

        for (int i = 1; i <= N; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        // 초기화
        int[] dp = new int[10001];
        dp[1] = wine[1];
        if (N > 1){
            dp[2] = wine[1] + wine[2];
        }

        for (int i = 3; i < N+1; i++) {
            // 현재 잔x, 현재잔 + 이전전잔, 현재잔 + 이전잔 + 이전전잔
            dp[i] = Math.max(dp[i-1], wine[i] + dp[i-2]);
            dp[i] = Math.max(dp[i], wine[i] + wine[i-1] + dp[i-3]);
        }

        bw.write(dp[N] + "");
        bw.flush();
        bw.close();
    }
}