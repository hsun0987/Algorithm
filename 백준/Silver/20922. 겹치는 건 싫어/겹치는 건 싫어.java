import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        HashMap<Integer, Integer> map = new HashMap<>(); // 수, 겹침수
        int start = 0, end = 0, len = 0;
        int answer = 0;

        while (end < N){
            int now = arr[end];
            map.put(now, map.getOrDefault(now, 0) + 1);
            end++;

            // K 보다 크면 start 범위 줄이기
            while (map.get(now) > K){
                int s = arr[start];
                map.put(s, map.get(s) - 1);
                if (map.get(s) == 0) map.remove(s);
                start++;
            }

            answer = Math.max(answer, end - start);
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
}