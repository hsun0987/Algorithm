import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] graph;
    static boolean[] vistited;
    static Queue<Integer> q;
    static int answer;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        graph = new boolean[N+1][N+1];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = true;
            graph[b][a] = true;
        }

        vistited= new boolean[N+1];
        q = new LinkedList<>();
        answer = 0;
        bfs(1);

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }

    static void bfs(int idx){
        q.add(idx);
        vistited[idx] = true;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int i = 1; i < N+1; i++) {
                if (!vistited[i] && graph[node][i]) {
                    q.add(i);
                    vistited[i] = true;
                    answer++;
                }
            }
        }
    }
}