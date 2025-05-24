import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[] visited;
    static int[] temp;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        temp = new int[M+1];
        sb = new StringBuilder();
        dfs(1);

        bw.write(sb + "");
        bw.flush();
        bw.close();
    }

    static void dfs(int depth){
        if (M+1 == depth){
            for (int i = 1; i <= M; i++) {
                sb.append(temp[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if(visited[i] || i < temp[depth - 1]){
                continue;
            }
            temp[depth] = i;
            visited[i] = true;
            dfs(depth+1);
            visited[i] = false;
        }
    }
}