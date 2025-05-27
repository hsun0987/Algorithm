import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] temp;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        temp = new int[M+1];
        sb = new StringBuilder();
        dfs(1);

        bw.write(sb + "\n");
        bw.flush();
        bw.close();
    }

    static void dfs(int depth){
        if (depth == M+1){
            for (int i = 1; i <= M; i++) {
                sb.append(temp[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (i < temp[depth-1]){
                continue;
            }

            temp[depth] = i;
            dfs(depth + 1);
        }
    }
}