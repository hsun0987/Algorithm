import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 최소 시간
        // 1. 필요한 시간이 적은 순으로 정렬
        // 2. 시간 누적합

        int n = Integer.parseInt(br.readLine());
        int[] p = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(p);
        
        int[] dp = new int[n];
        dp[0] = p[0];
        int answer = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] += dp[i-1] + p[i];
            answer += dp[i];
        }
        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
}