import java.io.*;
import java.util.*;

public class Main {
    static int[] ans = new int[2];
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 범위 초과 이슈로 타입 int -> long 변환
        long start = 1;
        long end = Arrays.stream(arr).max().getAsInt();

        while (start <= end){
            // 중간 값을 기준으로 탐색
            long mid = (start + end) / 2;
            long len = 0;

            for(int a : arr){
                if (a > mid)
                    len += a - mid;
            }

            // 원하는 길이보다 짧으면 더 분리
            if (len < m){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        bw.write(end + "\n");
        bw.flush();
        bw.close();
    }
}