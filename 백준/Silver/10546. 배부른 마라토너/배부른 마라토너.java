import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap <String, Integer> map = new HashMap<>();

        int t = Integer.parseInt(br.readLine());
        // 참여자
        for (int i = 0; i < t; i++) {
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        // 완주자
        for (int i = 0; i < t-1; i++) {
            String name = br.readLine();
            if(map.containsKey(name)){
                // 완주자의 이름이 참여자 명단에 있으면 값 -1
                map.put(name, map.get(name) - 1);
            }
        }

        for(String name : map.keySet()){
            // 완주자의 값이 0이 아니면 도달을 하지 못한 것
            if(map.get(name) != 0){
                bw.write(name);
            }
        }
        bw.flush();
        bw.close();
    }
}