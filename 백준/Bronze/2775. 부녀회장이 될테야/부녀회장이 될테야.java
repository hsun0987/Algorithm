import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            // a층
            int k = Integer.parseInt(br.readLine());
            // b호
            int n = Integer.parseInt(br.readLine());

            int[][] dp = new int[k+1][n+1];

            for (int j = 1; j < n+1; j++) {
                dp[0][j] = j;
            }

            for (int a = 1; a < k+1 ; a++) {
                for (int b = 1; b < n+1 ; b++) {
                    dp[a][b] = dp[a-1][b] + dp[a][b-1];
                }
            }
            bw.write(dp[k][n] + "\n");
        }
        bw.flush();
        bw.close();
    }
}