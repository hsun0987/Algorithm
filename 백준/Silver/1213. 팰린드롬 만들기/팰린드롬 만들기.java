import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split("");
        StringBuilder answer = new StringBuilder();

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
            int n = map.get(i);
            // 홀수면
            if (n % 2 == 1){
                odd = i;
                cnt++;
                if (n == 1){
                    // 1이면 가운데 하나만 쓰면 되니까 건너뜀
                    continue;
                }
                // 3 이상이면 1개 빼고 다 써줘야함
                n -= 1;
            }
            // 팰린드롬 만들기
            // 개수의 절반을 적고 뒤집어서 뒤에 붙여주자
            for (int j = 0; j < n / 2; j++) {
                answer.append(i);
            }
        }

        // 홀수 개인 알파벳이 2개 이상이면 팰린드롬 만들 수 없음
        if (cnt > 1) {
            bw.write("I'm Sorry Hansoo");
        }else{
            StringBuilder sb = new StringBuilder(answer);
            sb.reverse();

            // 홀수 1문자가 있으면 가운데에 붙여주기
            if (!odd.equals("")){
                answer.append(odd);
            }
            // 뒤집은 문자 절반 붙이기
            answer.append(sb);
            bw.write(answer + "");
        }

        bw.flush();
        bw.close();
    }
}