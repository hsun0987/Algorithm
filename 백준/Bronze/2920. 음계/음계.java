import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[8];
        for(int i = 0; i < 8; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        String answer = "";
        for (int i = 1; i < 8; i++) {
            if(arr[i] - arr[i-1] == 1){
                answer = "ascending";
            }else if(arr[i] - arr[i-1] == -1){
                answer = "descending";
            }else{
                answer = "mixed";
                break;
            }
        }

        bw.write(answer);
        bw.flush();
        bw.close();
    }
}