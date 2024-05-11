import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 숫자 n개의 배열
        // 2. n개의 배열 숫자 중 3장 고르기
        // 3. 3장의 합 < M 이나 M과 가장 근접
        // -> 모든 경우를 구한 후 가장 큰 값 구하기

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    int sum;
                    sum = arr[i] + arr[j] + arr[k];
                    if(sum > max && m >= sum){
                        max = sum;
                    }
                }
            }
        }

        bw.write(max + "");
        bw.flush();
        bw.close();
    }
}