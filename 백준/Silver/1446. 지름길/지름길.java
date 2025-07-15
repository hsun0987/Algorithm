import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[][] fastRoad = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                fastRoad[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dp = new int[10001];

        for (int i = 1; i < D+1; i++) {
            // 순차, 지름길 중 최솟값 저장 -> 지름길이 있을 경우
            dp[i] = dp[i-1] + 1;
            for (int[] road : fastRoad){
                // 도착지점 == n
                if (road[1] == i){
                    // 값이 두개일 경우 더 작은 값
                    dp[i] = Math.min(dp[i], dp[road[0]] + road[2]);
                }
            }
        }

        bw.write(dp[D] + "");
        bw.flush();
        bw.close();
    }
}