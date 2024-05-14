import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());
        for(int k = 0; k < input; k++) {
        	int n = Integer.parseInt(br.readLine());
            int[] dp = new int[12];
            // 1. 규칙성 찾기
            // 2. Bottom Up 구현
            // - 1~n 점화식 구하기

            // n=1
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
                     
            for(int i = 4; i <= n; i++) {
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }
            bw.write(dp[n] + "\n");
        }
        
        bw.flush();
        bw.close();
    }
}