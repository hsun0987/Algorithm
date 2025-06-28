import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int K;
    static boolean[] visited;
    static Queue<int[]> q;
    static int time;  // 걸린 최소 시간
    static int[] pre; // 이동 좌표

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];
        q = new LinkedList<>();
        time = 0;
        pre = new int[100001];
        bfs(N);

        ArrayList<Integer> list = new ArrayList<>();

        // K부터 N까지 역추적
        int i = K;
        while(i != N){
            list.add(i);
            i = pre[i];
        }
        list.add(N);
        Collections.reverse(list); // 뒤집기

        bw.write(time + "\n");
        for(int l: list){
            bw.write(l + " ");
        }
        bw.flush();
        bw.close();
    }

    static void bfs(int node){
        visited[node] = true;
        q.add(new int[]{node, time});

        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0];
            int t = now[1];

            if (x == K){
                time = t;
                return;
            }

            int[] next = new int[]{x+1, x-1, x*2};
            for (int nx : next) {
                if (nx >= 0 && nx <= 100000 && !visited[nx]){
                    q.add(new int[]{nx, t+1});
                    visited[nx] = true;
                    pre[nx] = x; // 다음 위치에 현재 위치 저장 -> 연결고리 만들기
                }
            }

        }
    }
}