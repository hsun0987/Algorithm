import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        Arrays.sort(arr);
        
        int answer = 0;

        for (int i = 0; i < arr.length; i++) {
            int x = arr[i] * (n-i);
            if(x > answer){
                answer = x;
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
}