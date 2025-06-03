import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] TP = new int[N+1][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            TP[i] = new int[]{T, P};
        }

        int[] dp = new int[N+2]; // N+1 까지 고려

        for (int i = 0; i < N+1; i++) {
            int t = TP[i][0];
            int p = TP[i][1];

            // i일에 상담 하지 않은 경우(0 방지)
            dp[i+1] = Math.max(dp[i+1], dp[i]);

            if(i+t <= N){
                dp[i+t] = Math.max(dp[i+t], p + dp[i]);
            }
        }

        bw.write(dp[N] + "");
        bw.flush();
        bw.close();
    }
}