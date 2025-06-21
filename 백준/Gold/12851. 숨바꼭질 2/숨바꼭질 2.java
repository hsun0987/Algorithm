import java.io.*;
import java.util.*;

public class Main {
    static int[] visited;
    static Queue<int[]> q;
    static int K;
    static int cnt;
    static int minTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new int[100001]; // 여러번 방문하기 위해서 boolean 말고 int로 저장
        q = new LinkedList<>();
        cnt = 0;
        minTime = Integer.MAX_VALUE;
        bfs(N);

        bw.write(minTime + "\n" + cnt);
        bw.flush();
        bw.close();
    }

    static void bfs(int n){
        visited[n] = 0;
        q.add(new int[]{n, 0});

        while (!q.isEmpty()){
            int[] node = q.poll();
            int x = node[0];
            int time = node[1];

            // 시간이 더 오래걸리면 그냥 무시
            if (time > minTime) continue;

            // 현재 위치가 목적지인지 확인
            if (x == K){
                if(minTime == time){
                    cnt++;
                }

                if (minTime > time){
                    minTime = time;
                    cnt = 1; // 새로운 최소 시간 발견 -> 초기화
                }
                continue;
            }

            // x+1, x-1, 2x
            int[] next = new int[]{x+1, x-1, x*2};

            for(int nx: next){
                if (nx >= 0 && nx <= 100000){
                    if (visited[nx] == 0 || visited[nx] == time + 1){ // 방문x거나 이전과 같은 시간에 도달
                        q.add(new int[]{nx, time + 1});
                        visited[nx] = time + 1;
                    }
                }
            }
        }
    }
}