import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split("");
        String answer = "";

        // 알파벳, 갯수
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length; i++) {
            String a = str[i];
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        // 알파벳 정렬
        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        String  odd = "";
        int cnt = 0;
        for (String i: keys){
            // 홀수면
            if (map.get(i) % 2 == 1){
                if (map.get(i) >= 3){
                    // 3 이상이면 1개 빼고 다 써줘야함
                    for (int j = 0; j < (map.get(i)-1) / 2; j++) {
                        answer += i;
                    }
                }
                odd = i;
                cnt++;
            } else { // 짝수면
                // 팰린드롬 만들기
                // 개수의 절반을 적고 뒤집어서 뒤에 붙여주자
                // 만약 홀수 문자가 있으면 그것을 가운데에 적어주기
                for (int j = 0; j < map.get(i) / 2; j++) {
                    answer += i;
                }
            }
        }

        // 홀수 개인 알파벳이 2개 이상이면 팰린드롬 만들 수 없음
        if (cnt > 1) {
            bw.write("I'm Sorry Hansoo");
        }else{
            StringBuilder sb = new StringBuilder(answer);
            sb.reverse();

            if (!odd.equals("")){
                answer += odd;
            }

            answer += sb + "";
            bw.write(answer + "");
        }

        bw.flush();
        bw.close();
    }
}