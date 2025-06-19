import java.io.*;
import java.util.*;

public class Main {
    static int N, S;
    static int[] arr;
    static int[] temp;
    static int answer;
    static int sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        temp = new int[N];
        answer = 0;

        dfs(0, 0, 0);

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }

    static void dfs(int index, int sum, int count){
        if (index == N){
            if (count >= 1 && sum == S){
                answer++;
            }
            return;
        }

        // 현재 원소 선택
        dfs(index + 1, sum + arr[index], count + 1);

        // 현재 원소 선택 안 함
        dfs(index + 1, sum, count);
    }
}