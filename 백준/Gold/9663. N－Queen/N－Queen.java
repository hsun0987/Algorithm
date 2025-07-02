import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        visited = new int[N]; // 열 단위로 1개씩
        answer = 0;
        dfs(0);

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }

    static void dfs(int row){
        if (row == N){
            answer++;
            return;
        }

        for (int col = 0; col < N; col++) { // 행은 고정 열 이동
            if(!isVisited(row, col)){
                visited[row] = col;
                dfs(row+1);
                visited[row] = 0;
            }
        }
    }

    static boolean isVisited(int row, int col){
        // 같은 열, 왼쪽 대각선, 오른쪽 대각선 아닐 경우에 말 놓기
        for (int i = 0; i < row; i++) { // 이전 ~ 지금 행까지
            if (visited[i] == col){
                return true;
            }
            // 대각선 : 행차이 == 열차이
            if(Math.abs(visited[i] - col) == Math.abs(i - row)){
                return true;
            }
        }
        return false;
    }
}