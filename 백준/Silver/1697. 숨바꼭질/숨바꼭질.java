import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static Queue<int[]> q;
    static int K;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];
        q = new LinkedList<>();
        cnt = 0;
        bfs(N);

        bw.write(cnt + "");
        bw.flush();
        bw.close();
    }

    static void bfs(int n){
        visited[n] = true;
        q.add(new int[]{n, cnt});

        while (!q.isEmpty()){
            int[] node = q.poll();
            int x = node[0];
            int time = node[1];

            // 현재 위치가 목적지인지 확인
            if (x == K){
                cnt = time;
                return;
            }

            // x+1, x-1, 2x
            int[] next = new int[]{x+1, x-1, x*2};

            for(int nx: next){
                if (nx >= 0 && nx <= 100000 && !visited[nx]){
                    q.add(new int[]{nx, time + 1});
                    visited[nx] = true;
                }
            }
        }
    }
}