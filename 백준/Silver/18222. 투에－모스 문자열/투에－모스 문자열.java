import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long K = Long.parseLong(br.readLine());

        long answer = quadTree(K - 1); // 인덱스번호 (0부터 시작)

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }

    static long quadTree(long k){
        if (k == 0){
            return 0;
        }else if (k % 2 == 0){ // 짝수
            return quadTree(k/2);
        } else {
            return 1 - quadTree((k-1) / 2);
        }
    }
}