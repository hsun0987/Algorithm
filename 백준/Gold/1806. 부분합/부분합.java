import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0;
        int sum = 0;
        int answer = Integer.MAX_VALUE; // 구간의 최소 길이

        while (true){
            if (sum >= S){
                answer = Math.min(answer, end - start);
                sum -= A[start++];
            }else{
                if (end == N) break;
                sum += A[end++];
            }
        }

        // S를 만들지 못한 경우
        if (answer == Integer.MAX_VALUE){
            answer = 0;
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
}