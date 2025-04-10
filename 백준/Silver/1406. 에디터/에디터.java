import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // L 왼쪽 D 오른쪽 B 왼쪽 pop P push
        // LinkedList 사용 시 시간 초과
        // 해결 -> left, right 2개 스택 사용

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            left.push(str.charAt(i));
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();

            switch (op){
                case "L":
                    // 왼 -> 오
                    if (!left.isEmpty()){
                        right.push(left.pop());
                    }
                    break;
                case "D":
                    // 오 -> 왼
                    if (!right.isEmpty()){
                        left.push(right.pop());
                    }
                    break;
                case "B":
                    // 왼쪽 스택 pop
                    if (!left.isEmpty()){
                        left.pop();
                    }
                    break;
                case "P":
                    // 왼쪽 스택에 push
                    char s = st.nextToken().charAt(0);
                    left.push(s);
                    break;
            }
        }

        // 스택을 배열처럼 접근하면 앞에서부터 출력가능!!
        for (char c : left) {
            bw.write(c);
        }
        while (!right.isEmpty()) {
            bw.write(right.pop());
        }

        bw.flush();
        bw.close();

    }
}