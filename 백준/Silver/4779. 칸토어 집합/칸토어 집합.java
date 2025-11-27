import java.io.*;

public class Main {
    static char[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true){
            String input = br.readLine();
            if (input == null || input.trim().isEmpty()){
                break;
            }

            int N = Integer.parseInt(input);
            int len = (int) Math.pow(3, N);
            arr = new char[len];
            for (int i = 0; i < len; i++) {
                arr[i] = '-';
            }
            divideAndConquer(len, 0, len-1);

            String answer = String.valueOf(arr);
            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
    }

    static void divideAndConquer(int n, int start, int end){
        if (start == end) {
            return;
        }

        int len = n / 3;

        // 왼쪽
        divideAndConquer(len, start, start + len - 1);
        // 가운데
        for (int i = start + len; i < start + 2 * len; i++) {
            arr[i] = ' ';
        }
        // 오른쪽
        divideAndConquer(len, start + 2 * len, end);
    }
}