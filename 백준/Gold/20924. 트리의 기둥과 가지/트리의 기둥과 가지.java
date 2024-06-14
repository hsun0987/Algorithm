import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<HashMap<Integer, Integer>> tree;
    static boolean[] visited;
    static int n, r;
    static int giga;
    static boolean isGiga;
    // 기둥
    static int woodLen;
    // 가지
    static int branch;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 기가 노드 : 처음 자식노드가 2개가 되는 노드
        // 기둥 = 루트 ~ 기가노드
        // 가지 = 기가노드 ~ 리프노드
        // 기둥과 가장 긴 가지의 길이를 구하라!

        // 1. 트리 그래프 생성
        // - a[b, 길이]
        // 2. 기가 노드 찾기
        // - 기가 노드까지 길이 합 구하기(-> 기둥임)
        // - 기가 노드를 찾으면 새로운 변수에 리프노드까지 길이 구하기(리프노드는 배열로 생성)
        // 3. 리프노드일 때 가장 긴 가지 길이 구하기

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        tree = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            tree.add(new HashMap<>());
        }

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            tree.get(a).put(b, c);
            tree.get(b).put(a, c);
        }

        visited = new boolean[n+1];
        giga = 0;
        isGiga = false;
        woodLen = 0;
        branch = 0;

        dfs(r, 0);

        // 기가 노드가 없었을 때 리프노드가 기가노드임
        if(!isGiga){
            woodLen = branch;
            branch = 0;
        }



        bw.write(woodLen + " " + branch);

        bw.flush();
        bw.close();
    }
    static void dfs(int idx, int len){
        visited[idx] = true;

        // 기가노드
        // 가지의 기둥이 없을 경우 유의 (루트이면서 자식을 2개 이상 가질 때)
        if(!isGiga && tree.get(idx).size() >= 3 || (idx == r && tree.get(idx).size() >= 2)){
            isGiga = true;
            giga = idx;
            // 기가 노드까지가 기둥
            woodLen = len;
            // 가지 길이를 측정하기 위해 len 초기화
            len = 0;
        }

        for (int i : tree.get(idx).keySet()) {
            if(!visited[i]){
                dfs(i, len + tree.get(idx).get(i));
            }
        }

        // 리프노드
        if(idx != r && tree.get(idx).size() == 1){
            if(branch <= len){
                branch = len;
            }
        }
    }
}