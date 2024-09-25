import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 층 n % h
        // 호수 n / h + 1

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int y, x;

            if (n % h == 0){
                y = h * 100;
                x = n / h;
            }else{
                y = (n % h) * 100;
                x = n / h + 1;
            }

            bw.write(y + x + "\n");
        }
        bw.flush();
        bw.close();
    }
}