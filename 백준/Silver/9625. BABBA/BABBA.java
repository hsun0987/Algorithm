import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());
        int[][] dp = new int[46][2];
        
        // f(1)
        dp[1][0] = 0;	// A
        dp[1][1] = 1;	// B
        
        // f(2)
        dp[2][0] = 1;
        dp[2][1] = 1;
        
        for(int i = 3; i <= k; i++) {
        	// f(n) = f(n-1) + f(n-2)
        	dp[i][0] = dp[i-1][0] + dp[i-2][0];
        	dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }
        
        bw.write(dp[k][0] + " " + dp[k][1]);
        bw.flush();
        bw.close();
    }
}