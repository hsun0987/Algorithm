import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] cable = new int[k];
        for (int i = 0; i < k; i++) {
            cable[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(cable);

        // int 타입으로 하면 범위 문제로 결과값이 음수가 나옴
        long start = 1;
        long end = cable[k-1];

        while (start <= end){
            // 1. 가장 긴 케이블을 기준으로 mid 구하기
            long mid = (start + end) / 2;
            long count = 0;
            // 2. 각 케이블 당 나올 수 있는 랜선 수 구하기(케이블 / mid)
            for (int c: cable){
                count += c / mid;
            }
            // 3. 랜선 수가 너무 적으면 mid를 기준으로 다시 중간값 구하기
            if (count < n){
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