import java.io.*;
import java.util.*;

public class Main {
    static char[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        long total = Integer.parseInt(br.readLine());

        long start = 0;
        long end = Arrays.stream(arr).max().getAsLong(); // 최대 예산값
        long answer = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;

            for (long a : arr){
                if (a <= mid) { // 요청 금액이 상한액(mid) 이하인 경우
                    sum += a; // 요청 금액 그대로 더하기
                }else {
                    sum += mid; // 상한액(mid)만큼 더하기!
                }
            }

            if (sum <= total) { // 예산 충분
                answer = mid;
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }

        bw.write(answer +"");
        bw.flush();
        bw.close();
    }
}