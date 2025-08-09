import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            arr[i] = new int[]{S, E};
        }

        // 끝나는 시간이 빠른 순으로 정렬(같은 경우 시작이 빠른 순)
        Arrays.sort(arr, (a, b) -> {
            if(a[1] == b[1]){
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });


        int beforeEnd = 0;
        int cnt = 0;
        for(int[] now : arr){
            int start = now[0];
            int end = now[1];

            if (start >= beforeEnd){
                cnt++;
                beforeEnd = end;
            }
        }

        bw.write(cnt + "");
        bw.flush();
        bw.close();
    }
}