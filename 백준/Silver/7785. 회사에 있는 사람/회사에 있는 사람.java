import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        HashSet<String> set = new LinkedHashSet<>();
        for (int i = 0; i < N; i++) {
           StringTokenizer st = new StringTokenizer(br.readLine());
           String name = st.nextToken();
           String el = st.nextToken();
            // enter이면 추가, leave면 제거
           if (el.equals("enter")){
               set.add(name);
           }else{
               set.remove(name);
           }
        }

        // 사전 내림차순
        List<String> sortset = new ArrayList<>(set);
        sortset.sort(Comparator.reverseOrder());

        for(String s : sortset){
            bw.write(s + "\n");
        }

        bw.flush();
        bw.close();
    }
}