import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int N;
    static int[][] S;
    static boolean[] selected;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        selected = new boolean[N];
        answer = Integer.MAX_VALUE; // 차이의 최솟값
        dfs(0, 0);

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }

    static void dfs(int depth, int start){
        if (depth == N/2){
            ArrayList<Integer> A = new ArrayList<>();
            ArrayList<Integer> B = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if(selected[i]){ // 조합에 골라진거면 A팀
                    A.add(i);
                }else{
                    B.add(i);
                }
            }
            sumAB(A, B);
            return;

        }

        for (int i = start; i < N; i++) { // 중복제거를 위해 시작점부터 시작
            if (!selected[i]){
                selected[i] = true;
                dfs(depth+1, i+1);
                selected[i] = false;
            }
        }
    }

    // 조합에 따른 Sij + Sji 합 구하기
    static void sumAB(ArrayList<Integer> A, ArrayList<Integer> B){
        int sumA = 0;
        int sumB = 0;
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.size(); j++) {
                if(i != j){
                    sumA += S[A.get(i)][A.get(j)];
                }
            }
        }

        for (int i = 0; i < B.size(); i++) {
            for (int j = 0; j < B.size(); j++) {
                if(i != j){
                    sumB += S[B.get(i)][B.get(j)];
                }
            }
        }

        answer = Math.min(answer, Math.abs(sumA - sumB));
    }
}