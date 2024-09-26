import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 참가자 수
        int n = Integer.parseInt(br.readLine());
        // 사이즈 별 신청자 수
        st = new StringTokenizer(br.readLine());
        int[] sizeList = new int[6];
        for (int i = 0; i < 6; i++) {
            sizeList[i] = Integer.parseInt(st.nextToken());
        }
        // 티셔츠와 펜의 묶음 수
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        // 티셔츠
        int tCount = 0;
        for (int i = 0; i < 6; i++) {
            if (sizeList[i] != 0 && sizeList[i] < T){
                tCount += 1;
            }else{
                if (sizeList[i] % T == 0){
                    tCount += sizeList[i] / T;
                }else{
                    tCount += sizeList[i] / T + 1;
                }
            }
        }

        // 펜
        //묶음: 총 인원/p
        int pCount = n / P;
        //개별: 총인원%p
        int pOne = n % P;

        bw.write(tCount + "\n" + pCount + " " + pOne);

        bw.flush();
        bw.close();
    }
}