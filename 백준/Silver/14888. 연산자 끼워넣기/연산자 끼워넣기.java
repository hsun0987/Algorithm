import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int[] op;
    static int[] visited;
    static int max, min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 수
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 연산자
        op = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        dfs(1, arr[0]);

        bw.write(max + "\n" + min);
        bw.flush();
        bw.close();
    }

    static void dfs(int depth, int current){
        if (depth == N){
            max = Math.max(max, current);
            min = Math.min(min, current);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if(op[i] > 0){
                op[i]--;
                int newValue = calculation(current, arr[depth], i);
                dfs(depth + 1, newValue);
                op[i]++;
            }
        }
    }

    static int calculation(int x, int y, int op){
        if(op == 0){    // 더하기
            return x + y;
        } else if (op == 1) {   // 빼기
            return  x - y;
        } else if (op == 2){    // 곱하기
            return x * y;
        } else if (op == 3){    // 나누기
            // x 음수일 경우 양수로 바꾼 후 몫을 음수로 변경
            if (x < 0){
                int newX = Math.abs(x);
                return newX / y * -1;
            }else{
                return x / y;
            }
        }
        return 0;
    }
}