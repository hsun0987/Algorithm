import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] temp;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        visited = new boolean[N];
        temp = new int[N];
        sb = new StringBuilder();
        dfs(0);

        bw.write(sb + "");
        bw.flush();
        bw.close();
    }

    static void dfs(int depth){
        if (depth == M){
            for (int i = 0; i < M; i++) {
                sb.append(temp[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]){
                temp[depth] = arr[i];
                visited[i] = true;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}