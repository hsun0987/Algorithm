import java.io.*;
import java.util.*;

public class Main {
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

        // start = 최소길이 end = 최대길이
        // 잘라진 길이의 합이 최대
        // sum(나무 길이 - mid) >= M -> 오른쪽 탐색

        long start = 1;
        long end = Arrays.stream(arr).max().getAsInt();

        while(start <= end){
            long mid = (start + end) / 2;

            long sum = 0;
            for(int a : arr){
                if(a > mid){
                    sum += a - mid;
                }
            }

            if (sum < m){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        bw.write(end + "");
        bw.flush();
        bw.close();
    }
}
