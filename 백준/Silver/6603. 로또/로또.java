import java.io.*;
import java.util.*;

public class Main {
    static int K;
    static int[] S;
    static int[] temp;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());

            if (K == 0){
                break;
            }

            S = new int[K];
            for (int i = 0; i < K; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }

            temp = new int[6];
            visited = new boolean[K];
            sb = new StringBuilder();
            dfs(0, 0);
            bw.write(sb.toString() + "\n");
        }

        bw.flush();
        bw.close();
    }

    static void dfs(int depth, int start){
        if (depth == 6){    // 로또는 6개를 뽑는다
            for (int i = 0; i < temp.length; i++) {
                sb.append(temp[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < K; i++) {
            if (!visited[i]){
                visited[i] = true;
                temp[depth] = S[i];
                dfs(depth+1, i+1);
                visited[i] = false;
            }
        }
    }
}