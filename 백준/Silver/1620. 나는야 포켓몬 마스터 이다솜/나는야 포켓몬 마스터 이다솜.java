import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<Integer, String> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            map1.put(i, name);
            map2.put(name, i);
        }

        for (int i = 0; i < m; i++) {
            String q = br.readLine();
            if (Character.isDigit(q.charAt(0))){
                bw.write(map1.get(Integer.parseInt(q)) + "\n");
            }else
                bw.write(map2.get(q) + "\n");
        }
        
        bw.flush();
        bw.close();
    }
}