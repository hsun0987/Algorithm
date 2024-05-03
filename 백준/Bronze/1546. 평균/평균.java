import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int N = Integer.parseInt(br.readLine());
       String s = br.readLine();
       String array[] = s.split(" ");

       int max = 0;
       double sum = 0;
       double[] result = new double[N];

        for (int i = 0; i < N; i++) {
            if(Integer.parseInt(array[i]) > max){
                max = Integer.parseInt(array[i]);
            }
        }
        for (int i = 0; i < N; i++) {
            result[i] = Double.parseDouble(array[i]) / max * 100;
            sum += result[i];
        }
        System.out.println(sum / N);
    }
}