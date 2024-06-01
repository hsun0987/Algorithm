import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 트리맵 이용 : 이진트리 기반 오름차순 정렬
        TreeMap<Integer, Integer> map;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            map = new TreeMap<>();

            for (int j = 0; j < n; j++) {
                String[] input = br.readLine().split(" ");
                int num = Integer.parseInt(input[1]);
                switch (input[0]){
                    // I : push
                    case "I":
                        // 같은 숫자가 없으면 default = 0, 있으면 +1
                        map.put(num, map.getOrDefault(num, 0) + 1);
                        break;
                    case "D":
                        // 비어있을 경우 : EMPTY
                        if(map.isEmpty()){
                            continue;
                        }
                        // D -1 : 최솟값 pop
                        if(num == -1){
                            int key = map.firstKey();
                            // map에 같은 수가 있을 경우 count -1
                            if(map.get(key) > 1){
                                map.put(key, map.get(key) -1);
                            }else{
                                // map에서 제거
                                map.remove(key);
                            }
                        }else {
                        // D 1 : 최댓값 pop
                            int key = map.lastKey();
                            // map에서 제거
                            if(map.get(key) > 1){
                                map.put(key, map.get(key) -1);
                            }else{
                                map.remove(key);
                            }
                        }
                        break;
                }
            }
            if(map.isEmpty()){
                System.out.println("EMPTY");
            }else{
                System.out.println(map.lastKey() + " " + map.firstKey());
            }
        }
    }
}