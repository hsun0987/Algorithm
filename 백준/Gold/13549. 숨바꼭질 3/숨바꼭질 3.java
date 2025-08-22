import java.io.*;
import java.util.*;

public class Main {
    static int[] dist;
    static Deque<Integer> dq;
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new int[100001];
        Arrays.fill(dist, Integer.MAX_VALUE); // 가장 큰 값으로 초기화
        dq = new ArrayDeque<>();

        bfs(N);

        bw.write(dist[K] + "");
        bw.flush();
        bw.close();
    }

    static void bfs(int n){
        dq.add(n);
        dist[n] = 0;

        while (!dq.isEmpty()){
            int x = dq.pollFirst();
            if (x == K){
                return;
            }

            int[] next = {
                    x - 1,
                    x + 1,
                    x * 2
            };

            for (int i = 0; i < 3; i++) {
                int nx = next[i];
                int sec = (i == 2) ? 0 : 1;

                if (0 <= nx && nx <= 100000 && dist[nx] > dist[x] + sec){
                    if (sec == 0){    // 0초를 앞에 넣기
                        dq.addFirst(nx);
                    }else{
                        dq.addLast(nx);
                    }
                    // 걸린 시간 누적
                    dist[nx] = dist[x] + sec;
                }
            }
        }
    }
}