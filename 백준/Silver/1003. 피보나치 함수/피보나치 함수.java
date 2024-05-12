import java.io.*;

public class Main {
    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());
        for (int i = 0; i < input; i++) {
            int n = Integer.parseInt(br.readLine());
            dp = new int[n+1][2];	// 0~N, 0/1

            // f(0) = 0
            dp[0][0] = 1;

            if(n > 0) {
                // f(1) = 1
                dp[1][1] = 1;
            }
            int[] fib = fibonacci(n);
            bw.write( fib[0] + " " + fib[1] + "\n");
        }
        bw.flush();
        bw.close();
    }
    static int[] fibonacci(int n) {
        if(dp[n][0] != 0 || dp[n][1] != 0) {
            return dp[n];
        }

        dp[n-1] = fibonacci(n-1);
        dp[n-2] = fibonacci(n-2);
        dp[n][0] = dp[n-1][0] + dp[n-2][0];
        dp[n][1] = dp[n-1][1] + dp[n-2][1];

        return dp[n];
    }
}