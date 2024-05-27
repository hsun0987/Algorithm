import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();

        int t = Integer.parseInt(br.readLine());

        int[] answer = new int[t];
        int[] arr = new int[t];

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < t; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int i = t - 1; i >= 0; i--) {
            // 스택에 탑의 번호를 넣고 배열에 있는 탑들과 비교
            // 더 큰 값이 있을 경우 수신 가능 -> 탑의 번호를 답에 넣음
            while(!stack.empty() && arr[stack.peek()] < arr[i]){
                answer[stack.peek()] = i + 1;
                stack.pop();
            }
            stack.push(i);
        }

        for (int i = 0; i < t; i++) {
            bw.write(answer[i] + " ");
        }

        bw.flush();
        bw.close();
    }
}