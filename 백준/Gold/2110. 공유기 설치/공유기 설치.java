import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long[] X = new long[N];
        for (int i = 0; i < N; i++) {
            X[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(X);

        long start = 1;
        long end = X[N-1];

        while (start <= end){
            long mid = (start + end) / 2;

            // cnt : 공유기 개수
            long cnt = 1;
            long lastC = X[0];  // 첫번째 공유기 설치

            for (int i = 1; i < N; i++) {
                // 현재 집 위치 - 이전 공유기 위치 ≥ mid 이면 공유기 설치
                if (X[i] - lastC >= mid){
                    cnt++;
                    // 공유기 설치 후 이전 공유기 업데이트
                    lastC = X[i];
                }
                // 오버플로우 방지
                if(cnt >= C){
                    break;
                }
            }

            if (cnt >= C){ // 널널함 왼쪽 탐색
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        bw.write(end + "");
        bw.flush();
        bw.close();
    }
}