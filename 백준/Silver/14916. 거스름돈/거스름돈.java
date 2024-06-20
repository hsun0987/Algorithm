import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        br.close();
        int answer = 0;

        // 5로 나누어 떨어지지 않으면 2를 빼준다
        while (n > 0){
            if(n % 5 == 0){
                answer += n / 5;
                break;
            }
            n -= 2;
            answer++;
        }

        if(n < 0){
            bw.write("-1");
        }else {
            bw.write(answer + "");
        }

        bw.flush();
        bw.close();
    }
}