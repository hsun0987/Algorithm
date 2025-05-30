import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[] visited;
    static int[] a;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        a = new int[M];
        sb = new StringBuilder();
        dfs(0);

        bw.write(sb + "\n");
        bw.flush();
        bw.close();
    }
    
    static void dfs(int depth){
        if (depth == M){
            for (int i = 0; i < a.length; i++) {
                sb.append(a[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i]){
                continue;
            }

            a[depth] = i;
            visited[i] = true;
            dfs(depth + 1);
            visited[i] = false;
        }
    }
}