import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. A배열 만들기
        // 2. 오름차순 정렬
        // - hashmap (숫자, 처음인덱스) 저장 후 찾는 숫자 탐색
        // 3. D가 있으면 위치 인덱스, 없으면 -1

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(list);

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int key = list[i];
            if (!map.containsKey(key)){
                map.put(key, i);
            }
        }

        for (int i = 0; i < m; i++) {
            int key = Integer.parseInt(br.readLine());

            if (map.containsKey(key)){
                bw.write(map.get(key) + "\n");
            }else{
                bw.write("-1\n");
            }
        }

        bw.flush();
        bw.close();
    }
}