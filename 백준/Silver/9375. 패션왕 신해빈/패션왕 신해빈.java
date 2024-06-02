import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap <String, Integer> map;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            map = new HashMap<>();
            int answer = 1;
            for (int j = 0; j < n; j++) {
                String[] ac = br.readLine().split(" ");
                // 악세서리 종류와 개수 저장
                map.put(ac[1], map.getOrDefault(ac[1], 0) + 1);
            }
            for(String key : map.keySet()){
                // 일반화 식 = 개수 + 1의 값을 모두 곱한 후 - 1
                // ex. h 2, e 1 = (2+1) * (1+1) - 1 = 3 * 2 - 1 = 5
                answer *= map.get(key) + 1;
            }
            bw.write(answer - 1 + "\n");
        }
        bw.flush();
        bw.close();
    }
}