import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int h = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        // 45분 일찍 알람 설정하기
        // 시 0 ~ 23, 분 0 ~ 59
        // ex 10 : 10 => 9 : 25
        // 10 - 1 : 10 + 60 - 45

        // 0시 일 때만 23시
        if(h == 0){
            h = 23;
        }else
            h -= 1;

        //분
        m += 15;
        // if (0 : 45)
        if(m >= 60){
            h += 1;
            m = m - 60;
            if(h == 24){
                h = 0;
            }
        }

        /* 다른 풀이
         m -= 45;
        if(m < 0){
            h -= 1;
            m += 60;
        }
        if (h < 0){
            h += 24;
        }
        */

        bw.write(h + " " + m);
        bw.flush();
        bw.close();
    }
}
