import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if (s.length() >= M){
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }

        List<String> keySet = new ArrayList<>(map.keySet());

        Collections.sort(keySet, new Comparator<String>() {
            public int compare(String o1, String o2) {
                // 1. 빈도수 내림차순
                int freq1 = map.get(o1);
                int freq2 = map.get(o2);
                if (freq1 != freq2){
                    return freq2 - freq1;
                }

                // 빈도수가 같을 경우
                // 2. 길이 내림차순
                if (o1.length() != o2.length()){
                    return o2.length() - o1.length();
                }

                // 3. 사전 순 오름차순
                return o1.compareTo(o2);
            }
        });


        for (String key : keySet){
            bw.write(key + "\n");
        }

        bw.flush();
        bw.close();
    }
}