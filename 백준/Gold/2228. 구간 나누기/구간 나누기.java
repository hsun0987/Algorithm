import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        int[] sum = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            // 미리 누적값 계산
            sum[i] = sum[i-1] + arr[i];
        }

        // 초기값
        int[][] dp = new int[N+1][M+1];
        // 최소값으로 초기화 -> 음수가 나오는 것을 방지
        Arrays.fill(dp[0], -32768 * 101);
        dp[0][0] = 0; // 아무것도 선택 안 한 상태

        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < M+1; j++) {
                dp[i][j] = dp[i-1][j]; // 이전 값
                for (int k = i; k > 0; k--) {
                    // k~i 구간 합 = Sum[i] - Sum[k-1]
                    int intervalSum = sum[i] - sum[k - 1];

                    if(k-2 >= 0){
                        dp[i][j] = Math.max(dp[i][j], dp[k-2][j-1] + intervalSum);
                    }else if(j == 1) {
                        dp[i][j] = Math.max(dp[i][j], intervalSum);
                    }
                }
            }
        }

        bw.write(dp[N][M] + "");
        bw.flush();
        bw.close();
    }
}