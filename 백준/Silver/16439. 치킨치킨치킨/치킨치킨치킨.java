import java.io.*;
import java.util.*;

public class Main {
    static int answer;
    static boolean[] visited;
    static int[] temp;
    static int N, M;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = 0;
        visited = new boolean[M];   // 치킨 수
        temp = new int[3]; // 치킨 조합(3)
        dfs(0);


        bw.write(answer + "");
        bw.flush();
        bw.close();
    }

    static void dfs(int depth){
        if(depth == 3){
            int sum = 0;
            // 인덱스에 해당하는 각 치킨 선호도 별 최댓값
            for (int i = 0; i < N; i++) {
                // 인덱스 당 최댓값의 합 구하기
                sum += Math.max(Math.max(arr[i][temp[0]], arr[i][temp[1]]), arr[i][temp[2]]);
            }
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < M; i++) {
            if(!visited[i]){
                temp[depth] = i;
                visited[i] = true;
                dfs(depth + 1);
                visited[i] = false;

            }
        }
    }
}