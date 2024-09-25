import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 중복한 값은 저장X => 서로 다른 나머지 값만 저장 
        HashSet set = new HashSet();

        for(int i = 0; i < 10; i++){
            int n = Integer.parseInt(br.readLine());
            set.add(n % 42);
        }

        bw.write(set.size() + "");

        bw.flush();
        bw.close();
    }
}