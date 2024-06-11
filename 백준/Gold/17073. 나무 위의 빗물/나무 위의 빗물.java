import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 물이 움직이지 않는 상태 -> 리프노드에 물이 다 이동됨
        // 리프노드가 나눠갖는 물의 양이 일정하기 때문에 합은 항상 물의 양임
        // 따라서 평균 = 물의 양/ 리프노드

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        // 리프노드 구하기
        int leaf = 0;
        for (int i = 2; i < n+1; i++) {
            // 자식(인접) 노드가 없으면 리프노드 -> dfs 안해도 됨
            if(tree.get(i).size() == 1){
                leaf++;
            }
        }

        // 평균 = 물의 양/ 리프노드
        double answer = (double) w / leaf;
        bw.write( answer + "");

        bw.flush();
        bw.close();
    }
}