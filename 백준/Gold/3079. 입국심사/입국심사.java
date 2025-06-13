import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        long start = 1;
        long end = Arrays.stream(arr).max().getAsLong() * M; // max * 인원수

        while (start <= end){
            // start + end에서 오버플로우가 발생 가능
            long mid = start + (end - start) / 2;
            long sum = 0;
            // sum = 심사대 시간당 처리할 수 있는 인원 수(mid / Tk)
            for(long a : arr){
                sum += mid / a;
                // 인원수가 오버플로우 발생 가능 -> 인원 수가 넘어가면 중단
                if(sum >= M){
                    break;
                }
            }

            if (sum >= M){   // 시간 남음 -> 왼쪽 탐색
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        bw.write(start + "");
        bw.flush();
        bw.close();
    }
}