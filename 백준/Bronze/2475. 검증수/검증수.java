import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr =  br.readLine().split(" ");
        double sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += Math.pow(Integer.parseInt(arr[i]), 2);
        }

        int answer = (int)(sum % 10);
        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
}