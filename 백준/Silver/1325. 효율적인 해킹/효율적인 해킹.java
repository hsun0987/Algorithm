import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static List<Integer>[] graph;
    static int[] computer;
    static int n, cnt;

    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // ** 방향 그래프
        // 1. B에 연결된 A 로 그래프 생성 >> bfs/dfs 이용
        // 2. 각 컴퓨터 마다 지나는 컴퓨터의 개수 세기
        // 3. 최댓값 구한 후 최대인 컴퓨터 구하기

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   // 노드 수
        int m = Integer.parseInt(st.nextToken());   // 입력 수

        graph = new List[n+1];
        for (int i = 0; i < n+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }

        computer = new int[n+1];
        cnt = 0;

        q = new LinkedList<>();

        //dfs 이용
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n+1];
            dfs(i);
            //bfs(i);
        }

        int max = Arrays.stream(computer).max().getAsInt();
        for (int i = 1; i < computer.length; i++) {
            if (computer[i] == max){
                bw.write(i + " ");
            }
        }

        bw.flush();
        bw.close();
    }

    public static void dfs(int node){
        visited[node] = true;

        for (int i : graph[node]) {
            if (visited[i]) continue;
            computer[i]++;
            dfs(i);
        }
    }
    
    public static void bfs(int node){
        q.add(node);
        visited[node] = true;

        while(!q.isEmpty()){
            int idx = q.poll();
            for (int i : graph[idx]) {
                if (visited[i]) continue;
                computer[i]++;
                q.add(i);
                visited[i] = true;
            }
        }
    }
}