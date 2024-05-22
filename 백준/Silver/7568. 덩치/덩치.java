import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        // 1. (키, 몸무게) 2차원 배열 생성
        int[][] arr = new int[n][2];

        for (int i = 0; i < arr.length; i++) {
            String[] xy = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(xy[0]);
            arr[i][1] = Integer.parseInt(xy[1]);
        }

        // 2. 키와 몸무게가 둘 다 큰 사람 수 + 1
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]){
                    count ++;
                }
            }
            bw.write(count+1 + " ");
        }
        bw.flush();
        bw.close();
    }
}