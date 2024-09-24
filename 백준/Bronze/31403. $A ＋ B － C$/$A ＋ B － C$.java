import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[3];
        for(int i = 0; i < 3; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        int a = 0;
        int b = 0;

        a = arr[0] + arr[1] - arr[2];
        b = Integer.parseInt(Integer.toString(arr[0]) + Integer.toString(arr[1])) - arr[2];

        bw.write(a + "\n" + b);
        bw.flush();
        bw.close();
    }
}