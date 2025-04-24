import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        dp[1] = 0;

        //2 //3 -1 이 될 수 있는 경우를 구한 후 그 중 최솟값을 dp에 저장
        // dp[n] = min(dp[n-1] + 1, dp[n//2], dp[n//3])
        // 이전값+1, 2의 배수일 경우+1, 3의 배수일 경우+1

        for (int i = 2; i < n+1; i++) {
            dp[i] = dp[i-1] + 1;

            if (i % 2 == 0){
                dp[i] = Math.min(dp[i], dp[i/2] + 1);
            }
            if (i % 3 == 0){
                dp[i] = Math.min(dp[i], dp[i/3] + 1);
            }
        }
        bw.write(dp[n] + "");
        bw.flush();
        bw.close();
    }
}