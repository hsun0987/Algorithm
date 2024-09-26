import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int num = 666;
        int ans = num;

        // n = 1 이 될 때까지 반복(제일 작은 수를 구하기 위해)
        while (n - 1 > 0){
            // 1씩 증가시키면서 일일이 비교
            num += 1;
            // 666을 포함하면 ans 갱신
            if (Integer.toString(num).contains("666")){
                ans = num;
                n -= 1;
            }
        }

        bw.write(ans + " ");
        bw.flush();
        bw.close();
    }
}