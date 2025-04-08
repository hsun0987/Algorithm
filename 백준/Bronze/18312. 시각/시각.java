import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String k = st.nextToken();
        int answer = 0;

        for (int i = 0; i <= n; i++) {
            String si = fn(i);
            for (int j = 0; j < 60; j++) {
                String sj = fn(j);
                for (int l = 0; l < 60; l++) {
                    String sl = fn(l);
                    
                    String str = si + sj + sl;
                    if (str.contains(k)){
                        answer++;
                    }
                }
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }

    static String fn(int x){
        if (x < 10){
            return "0" + x;
        }else{
            return "" + x;
        }
    }
}