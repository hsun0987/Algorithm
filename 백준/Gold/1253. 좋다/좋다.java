import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int answer = 0;

        for (int i = 0; i < N; i++) {
            int start = 0, end = N-1;
            while(start < end){
                // 자기 자신 제외
                if (start == i){
                    start++;
                    continue;
                }
                if (end == i){
                    end--;
                    continue;
                }

                int sum = arr[start] + arr[end];

                if (sum == arr[i]){
                    answer++;
                    break;
                }else if (sum < arr[i]){
                    start++;
                }else{
                    end--;
                }
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
}