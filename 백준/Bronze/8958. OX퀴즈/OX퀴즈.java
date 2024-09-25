import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int sum = 0;
            int n = 1;
            String st = br.readLine();
            for (int j = 0; j < st.length(); j++) {
                if(st.charAt(j) == 'O'){
                    sum += 1 * n;
                    n++;
                }else{
                    n = 1;
                }
            }

            bw.write(sum + "\n");
        }

        bw.flush();
        bw.close();
    }
}