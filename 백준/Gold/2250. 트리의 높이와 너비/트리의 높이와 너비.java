import java.io.*;
import java.util.*;

public class Main {
    static class node{
        int left;
        int right;
        int parent;
        node(int left, int right){
            this.left = left;
            this.right = right;
            this.parent = -1;
        }
    }
    // 깊이 별 노드 저장 -> 노드의 번호 말고 <레벨, 열 번호> 로 저장
    static HashMap<Integer, ArrayList<Integer>> levels;
    // 각 레벨의 노드의 열 번호 저장할 변수
    static int column;
    static node[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 1. 트리 만들기
        // 2. DFS 를 이용하여 깊이와 각 레벨 별 노드의 열 번호 구하기
        // - 키, 값 형식으로 저장
        // 3. 너비의 최댓값 비교해서 구하기
        // - 너비 = 맨 오른쪽 노드(max) - 맨 왼쪽 노드(min) + 1

        int n = Integer.parseInt(br.readLine());
        tree = new node[n+1];
        for (int i = 0; i < n+1; i++) {
            tree[i] = new node(-1, -1);
        }
        int root = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            tree[v].left = l;
            tree[v].right = r;

            if(tree[v].left != -1)
                tree[l].parent = v;

            if(tree[v].right != -1)
                tree[r].parent = v;
        }

        for (int i = 1; i < n+1; i++) {
            // 부모 노드가 없으면 루트노드
            if(tree[i].parent == -1){
                root = i;
                break;
            }
        }

        levels = new HashMap<>();
        int depth = 0;
        column = 0;
        // 중위 순회
        dfs(root, depth);

        int maxWid = 0;
        int maxLv = 0;

        for(int key : levels.keySet()){
            // 레벨의 열 정보들
            Integer[] cols = levels.get(key).stream().toArray(Integer[]::new);
            Arrays.stream(cols).sorted();
            // 너비 = max - min + 1
            int w = cols[cols.length - 1] - cols[0] + 1;
            if(w > maxWid){
                maxWid = w;
                maxLv = key;
            }
        }

        bw.write(maxLv + 1 + " " + maxWid);
        bw.flush();
        bw.close();
    }

    // 깊이 별 열구하기
    static void dfs(int idx, int d){
        if(idx == -1){
            return;
        }
        node n = tree[idx];

        if(n == null) return;

        // 해당 레벨이 없으면 해시맵 생성
        if(!levels.containsKey(d)){
            levels.put(d, new ArrayList<>());
        }

        dfs(n.left, d + 1);

        column += 1;
        levels.get(d).add(column);

        dfs(n.right, d + 1);
    }
}