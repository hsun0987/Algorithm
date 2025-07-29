import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0;
        int sum = 0;
        int answer = 0;

        while (true){
            if(sum >= M){
                if(sum == M){
                    answer++;
                }
                sum -= A[start++];
            } else {
                if(end == N) break;
                sum += A[end++];
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
}