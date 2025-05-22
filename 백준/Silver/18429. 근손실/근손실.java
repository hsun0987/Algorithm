import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static int answer;
    static int n, k;
    static int[] kit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        kit = new int[n];
        for (int i = 0; i < n; i++) {
            kit[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[n];
        answer = 0;
        dfs(0, 500);

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
    
    static void dfs(int idx, int weight){
        if (weight < 500){
            return;
        }
        
        if (idx == n){
            answer++;
            return;
        }

        // k만큼 중량 감소
        weight -= k;

        for (int i = 0; i < n; i++) {
            if (visited[i]){
                continue;
            }

            visited[i] = true;
            dfs(idx+1, weight + kit[i]);
            visited[i] = false;
        }
    }
}