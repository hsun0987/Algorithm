import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+2];
        arr[0] = 0;
        arr[N + 1] = L;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int start = 1;
        int end = L;
        int answer = 0;

        while (start <= end){
            int mid = (start + end) / 2;
            int cnt = 0;

            for (int i = 0; i < arr.length - 1; i++) {
                int dist = arr[i+1] - arr[i];
                if (dist >= mid) { // 휴게소 배치가능
                    // 추가할 휴게소 수 = 쪼개진 조각 수 - 1
                    // (ex. 100 / 30 -> 30 30 30 10 => 4-1)
                    cnt += (dist + mid - 1) / mid - 1;
                }
            }

            if (cnt <= M){// 부족 오른쪽 탐색
                answer = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
}