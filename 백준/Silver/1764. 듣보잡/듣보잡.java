import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashSet<String> map1 = new HashSet<>();
        ArrayList<String> arr = new ArrayList<>();
        
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            map1.add(name);
        }

        for (int i = 0; i < m; i++) {
            String q = br.readLine();
            if(map1.contains(q)){
                arr.add(q);
            }
        }

        Collections.sort(arr);
        bw.write(arr.size() + "\n");
        for (int i = 0; i < arr.size(); i++) {
            bw.write(arr.get(i) + "\n");
        }
        bw.flush();
        bw.close();
    }
}