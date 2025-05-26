import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(br.readLine());
        // 비트마스크 이용 -> 2진수 변환했을 때 1의 개수
        int answer = Integer.bitCount(X);

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
}