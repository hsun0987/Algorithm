import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[91];

        dp[1] = 1;

        for (int i = 2; i < N+1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        bw.write(dp[N] + "");
        bw.flush();
        bw.close();
    }
}