import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        // 5의 제곱근으로 나누어 떨어질 경우 끝자리가 0이 된다
        for (int i = 1; i < n+1; i++) {
            if(i % 5 == 0){
                answer++;
            }
            if(i % 25 == 0){
                answer++;
            }
            if(i % 125 == 0){
                answer++;
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
}