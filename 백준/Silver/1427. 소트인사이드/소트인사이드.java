import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 입력값을 잘라서 배열로 저장(String -> char arr)
        char[] arr = br.readLine().toCharArray();
        // 2. 정렬
        Arrays.sort(arr);

        // 문자열로 변경 후 뒤집기(StringBuilder 사용)
        String answer = new StringBuilder(new String(arr)).reverse().toString();

        bw.write(answer);
        bw.flush();
        bw.close();
    }
}