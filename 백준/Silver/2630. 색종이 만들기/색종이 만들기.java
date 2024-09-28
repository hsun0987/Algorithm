import java.io.*;
import java.util.*;

public class Main {
    static int[] ans = new int[2];
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dac(0, 0, n);

        bw.write(ans[0] + "\n" + ans[1]);
        bw.flush();
        bw.close();
    }

    public static void dac(int i, int j, int n){
        // 현재 기준: 첫번째 색
        int color = arr[i][j];

        for (int y = i; y < i + n; y++) {
            for (int x = j; x < j + n; x++) {
                // 색종이의 각 부분의 색깔이 첫번째 조각의 색깔과 같은지 확인한다.
                if (color != arr[y][x]){
                    // 같지 않으면 다시 4등분
                    int quarter = n / 2;
                    dac(i, j, quarter);
                    dac(i, j+quarter, quarter);
                    dac(i+quarter, j, quarter);
                    dac(i+quarter, j+quarter, quarter);
                    // 조각이 1개가 될 때까지 반복한다.
                    return;
                }
            }
        }
        // 모든 색이 같으면 한 조각으로 본다. => 해당 색 +1
       ans[color] += 1;
    }
}