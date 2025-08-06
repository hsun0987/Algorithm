import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            arr[i] = new int[]{S, T};
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]); // 시작 시간 기준 정렬

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 끝시간 기준 정렬

        for (int[] now: arr){
            int s = now[0];
            int t = now[1];

            if (!pq.isEmpty() && pq.peek() <= s){ // 이어서 사용
                pq.poll();
            }

            pq.add(t);
        }

        bw.write(pq.size() + "");
        bw.flush();
        bw.close();
    }
}