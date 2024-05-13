import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];

        // n=1
        dp[1] = 0;

        for(int i = 2; i <= n; i++) {
            // +1, %2, %3 연산 모두 한 후 최소값 저장
            // dp[2]부터 이전값+1, i//2 + 1, i//3 + 1 값 중 최솟값을 저장함
            dp[i] = dp[i-1]+1;
            if(i % 2 == 0) {
            	if(dp[i/2]+1 < dp[i]) {
            		dp[i] = dp[i/2]+1;
            	}
            }
            if(i % 3 == 0) {
            	if(dp[i/3]+1 < dp[i]) {
            		dp[i] = dp[i/3]+1;
            	}
            }
        }
        
        bw.write(dp[n] + "");
        bw.flush();
        bw.close();
    }
}