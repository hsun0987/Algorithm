import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // ** 줄 서는 순서에 따라 돈 인출 최소 시간 합 구하기

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }
        // 1. P가 최소가 되도록 정렬 -> 시간이 짧은 순서대로(오름차순)
        Arrays.sort(p);

        // 2. 합 구하기
        int answer = 0;
        int sum;
        for(int i = 0; i < n; i++) {
            sum = 0;
            for(int j = 0; j <= i; j++) {
                sum += p[j];
            }
            answer += sum;
        }
        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
}