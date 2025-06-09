import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] temp;
    static boolean[] visited;
    static Set<String> set;
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
        temp = new int[M];
        set = new LinkedHashSet<>();    // 입력 순서 유지
        dfs(0);

        for (String i: set){
            bw.write(i + "\n");
        }

        bw.flush();
        bw.close();
    }

    static void dfs(int depth){
        StringBuilder sb = new StringBuilder();
        if (depth == M){
            for (int i = 0; i < M; i++) {
                sb.append(temp[i] + " ");
            }
            set.add(sb.toString());
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