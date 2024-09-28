import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            // 값이 int형 범위 초과 문제 -> long
            long[] p = new long[101];

            // 초기값
            p[1] = 1;
            p[2] = 1;
            p[3] = 1;

            if (n < 4){
                bw.write("1 \n");
            }else {
                for (int j = 4; j < n+1; j++) {
                    // 점화식
                    p[j] = p[j-3] + p[j-2];
                }
                bw.write(p[n] + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}