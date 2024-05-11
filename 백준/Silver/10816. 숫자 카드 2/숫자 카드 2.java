import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 가지고 있는 카드 배열1
        // - 해시맵 (카드번호, 카드개수)
        // 2. 찾을 숫자 배열2
        // 3. 배열1에 배열2가 몇개 포함되어 있는지
        // - 카드번호와 같은 키 찾고 그 값 리턴

        HashMap<Integer, Integer> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (map.containsKey(num)){
                bw.write(map.get(num) + " ");
            }else{
                bw.write("0 ");
            }
        }

        bw.flush();
        bw.close();
    }
}