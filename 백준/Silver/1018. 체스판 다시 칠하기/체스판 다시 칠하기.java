import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] chess = new String[N];
        for (int i = 0; i < N; i++) {
            chess[i] = br.readLine();
        }

        // 8*8 크기로 잘라주기
        // 최종 최솟값
        int answer = Integer.MAX_VALUE;
        // 8개씩 잘라줘
        // ex) if n = 10, i = 10-8 = 2
        // -> (0,0) / (1,0) / (2,0) 부터 시작하는 범위 탐색
        for (int i = 0; i <= N-8; i++) {
            for (int j = 0; j <= M-8; j++) {
                // 각 잘라진 체스판의 최솟값(W,B 중 최솟값)
                int min = getMinCount(i, j, chess);
                answer = Math.min(answer, min);
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }

    static int getMinCount(int sr, int sc, String[] chess){
        // w기준 초기값
        String[] wb = {"WBWBWBWB", "BWBWBWBW"};
        int wc = 0;

        for (int i = 0; i < 8; i++) {
            int row = sr + i;
            for (int j = 0; j < 8; j++) {
                int col = sc + j;
                if (chess[row].charAt(col) != wb[i % 2].charAt(j)){
                    wc++;
                }
            }
        }
        // w, b 중 최솟값 리턴
        return Math.min(wc, 64 - wc);
    }
}