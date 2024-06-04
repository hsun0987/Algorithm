import java.io.*;
import java.util.*;

public class Main {
    // 트리의 높이
    static int h;
    // 입력한 배열
    static int[] arr;
    // 출력할 트리
    static List<ArrayList<Integer>> tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        h = Integer.parseInt(br.readLine());
        // 완전 이진 트리의 노드 개수 : 2^h -1 
        arr = new int[(int) Math.pow(2, h) - 1];
        // 입력한 배열 저장
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 출력한 트리 생성
        tree = new ArrayList<>();
        for (int i = 0; i < h; i++) {
            tree.add(new ArrayList<>());
        }
        
        // 탐색
        search(0, arr.length - 1, 0);

        for (int i = 0; i < h; i++) {
            for (int j : tree.get(i)) {
                bw.write(j + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static void search(int start, int end, int depth){
        if(depth == h){
            return;
        }
        
        // depth = 0 부터 시작 -> 위부터 루트 구함
        // 완전 이진 트리기 때문에 중간 값이 루트가 됨
        // 중간값
        int mid = (start + end) / 2;
        tree.get(depth).add(arr[mid]);
        
        // 왼쪽 노드
        search(start, mid - 1, depth + 1);
        // 오른쪽 노드
        search(mid + 1, end, depth + 1);
    }
}