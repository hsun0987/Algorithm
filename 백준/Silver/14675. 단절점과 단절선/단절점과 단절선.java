import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 단절점 : A를 거치지 않고 갈 수 있는 우회 경로가 존재하지 않을 경우 A는 단절점
        // 1. A보다 늦게 탐색 되는 정점들에서 A보다 먼저 탐색 되는 정점으로 가는 경로가 없는 경우
        // 2. 루트 노드로 잡은 특정 노드의 자식 수가 2개 이상이면 단절점

        // 트리는 사이클이 없기 때문에
        // 연결된 간선이 2개 이상이면 단절점
        // 모든 선이 단절선

        int n = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            tree.add(new ArrayList<>());
        }

        // 트리 그래프 생성
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        // 단절점, 단절선 질의
        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if (t == 1){
                if(tree.get(k).size() > 1){
                    bw.write("yes \n");
                }else{
                    bw.write("no \n");
                }
            }else{
                bw.write("yes \n");
            }
        }

        bw.flush();
        bw.close();
    }
}