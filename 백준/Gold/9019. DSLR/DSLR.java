import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static int[] pre;
    static char[] how;
    static Queue<Integer> q;
    static int B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            visited = new boolean[10000];
            pre = new int[10000];
            how = new char[10000];
            q = new LinkedList<>();

            bfs(A);

            // 역추적
            StringBuilder sb = new StringBuilder();

            int n = B;

            while(n != A){
                sb.append(how[n]);
                n = pre[n];
            }

            bw.write(sb.reverse() + "\n");
        }

        bw.flush();
        bw.close();
    }

    static void bfs(int n){
        visited[n] = true;
        q.add(n);

        while (!q.isEmpty()){
            int x = q.poll();

            int[] nexts = {
                    (x * 2) % 10000,            // d
                    (x == 0)? 9999: x-1,        // s
                    (x%1000) * 10 + (x / 1000), // l
                    (x % 10) * 1000 + (x / 10)  // r
            };

            char[] op = {'D', 'S', 'L', 'R'};
            for (int i = 0; i < 4; i++) {
                int nx = nexts[i];
                if (!visited[nx]){
                    q.add(nx);
                    visited[nx] = true;
                    pre[nx] = x;
                    how[nx] = op[i];

                    // 목표 숫자 만나면 끝
                    if (nx == B){
                        return;
                    }
                }
            }
        }
    }
}