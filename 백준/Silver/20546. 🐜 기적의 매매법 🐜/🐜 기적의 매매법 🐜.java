import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] stock = new int[14];
        for (int i = 0; i < 14; i++) {
            stock[i] = Integer.parseInt(s[i]);
        }

        // 남은 현금, 주식 수
        int[] jh = new int[2];
        int[] sm = new int[2];

        jh[0] = n;
        sm[0] = n;

        // 준현
        for (int i = 0; i < 14; i++) {
            int now = stock[i];
            if (jh[0] >= now){
                jh[1] += jh[0] / now;           // 주식 수
                jh[0] -= (jh[0] / now) * now;   // 잔돈
            }
        }

        // 성민
        for (int i = 3; i < 14; i++) {
            int now = stock[i];
            // 3연속 하락 시 매수
            if (stock[i-3] > stock[i-2] && stock[i-2] > stock[i-1]){
                if (sm[0] >= now){
                    sm[1] += sm[0] / now;           // 주식 수
                    sm[0] -= (sm[0] / now) * now;   // 잔돈
                }
            }
            // 3연속 상승 시 매도
            if (stock[i-3] < stock[i-2] && stock[i-2] < stock[i-1]){
                if (sm[1] > 0){ // 산 주식이 있을 경우
                    sm[0] += sm[1] * now;   // 주식 수 * 현재 주가
                    sm[1] = 0;
                }
            }
        }

        // 총 자산 = 현금 + 주가 * 주식수
        int jh_r = jh[0] + stock[13] * jh[1];
        int sm_r = sm[0] + stock[13] * sm[1];

        if (jh_r > sm_r){
            bw.write("BNP");
        }else if (jh_r < sm_r){
            bw.write("TIMING");
        }else{
            bw.write("SAMESAME");
        }

        bw.flush();
        bw.close();
    }
}