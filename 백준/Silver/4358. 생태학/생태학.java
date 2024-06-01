import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap <String, Integer> map = new TreeMap<>();

        // 종의 총 개수
        int len = 0;
        while (true){
            String input = br.readLine();
            if(input == null || input.isEmpty()){
                // null 확인이 없을 경우 런타임 에러
                break;
            }
            // 1. (종 이름, 종 개수)
            map.put(input, map.getOrDefault(input, 0) + 1);
            len ++;
        }

        // 2. 키 값을 기준으로 사전 순 정렬(오름차순) -> 트리맵 이용(자동 오름차순)
        List<String> keySet = new ArrayList<>(map.keySet());
        // 3. 비율 = 종 개수 / map 총개수 * 100
        for (String key : keySet) {
            System.out.print(key + " ");
            System.out.printf("%.4f \n",  (double) map.get(key) / len * 100);
        }
    }
}