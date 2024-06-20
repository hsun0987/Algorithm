import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        int[] coin = new int[]{5, 2};

        if(n > 100000 || n <= 1 || n == 3){
            System.out.println(-1);
            return;
        }

        int i = 0;
        while(n > 0){
            int c = coin[i];
            answer += n / c;
            n %= c;

            while(n % 2 != 0){
                n += 5;
                answer -= 1;
            }
            i = 1;
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
}