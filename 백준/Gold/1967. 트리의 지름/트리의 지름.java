import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<HashMap<Integer, Integer>> graph;
    static boolean[] visited;
    static int n;
    static int longer;
    // 가중치가 가장 큰 노드 저장할 변수
    static int node;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new HashMap<>());
        }
        visited = new boolean[n+1];

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            // a는 b의 부모
            // b : 자식, w : 가중치
            graph.get(a).put(b, w);
            graph.get(b).put(a, w);
        }

        longer = 0;
        node = 1;

        // 가장 가중치가 큰 리프노드
        dfs(1, 0);

        // 그 다음으로 큰 리프노드
        visited = new boolean[n+1];
        dfs(node, 0);

        bw.write(longer + "");

        bw.flush();
        bw.close();
    }

    public static void dfs(int idx, int depth){
        visited[idx] = true;

        for (int i : graph.get(idx).keySet()) {
            if(!visited[i]){
                // 방문할 때마다 가중치를 더해줌
                dfs(i, depth + graph.get(idx).get(i));
            }
        }
        // 특정 노드가 루트가 아니고 자식 노드가 없으면 리프노드
        // 리프노드일 때 이전 가중치보다 크면 치환
        if(idx != 1 && graph.get(idx).size() == 1){
            if(longer <= depth){
                longer = depth;
                node = idx;
            }
        }
    }
}