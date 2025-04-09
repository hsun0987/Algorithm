import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. map에 가지고 있는 카드와 갯수 저장
        // 2. (숫자카드, 갯수)
        // 3. 찾을 카드를 map에서 찾기 key가 없으면 0

        HashMap<Integer, Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int key = Integer.parseInt(st.nextToken());
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int key = Integer.parseInt(st.nextToken());
            if (map.containsKey(key)){
                sb.append(map.get(key) + " ");
            }else{
                sb.append("0 ");
            }
        }

        bw.write(sb + "");
        bw.flush();
        bw.close();
    }
}