import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int answer = 1;

        // nCk = n * n-1 / k!
        for (int i = 1; i <= k; i++) {
            answer *= n--;
            answer /= i;
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }
}