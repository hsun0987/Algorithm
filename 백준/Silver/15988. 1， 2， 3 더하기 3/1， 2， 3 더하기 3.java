import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            long[] dp = new long[1000001];
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 2;

            for (int i = 3; i <= n; i++) {
                dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % 1000000009;
            }

            bw.write(dp[n] + "\n");
        }

        bw.flush();
        bw.close();
    }
}