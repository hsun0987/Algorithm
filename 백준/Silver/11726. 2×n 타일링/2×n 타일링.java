import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        // 1. 규칙성 찾기
        // 2. Bottom Up 구현
        // - 1~n 점화식 구하기

        // n=1
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] % 10007 + dp[i-2] % 10007;
        }
        
        bw.write(dp[n] % 10007 + "");
        bw.flush();
        bw.close();
    }
}