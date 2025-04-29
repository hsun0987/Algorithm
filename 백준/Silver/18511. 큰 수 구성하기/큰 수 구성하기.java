import java.io.*;
import java.util.*;

public class Main {
    static String[] arr;
    static String[] p;
    static int max;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new String[k];
        for (int i = 0; i < k; i++) {
            arr[i] = st.nextToken();
        }

        Arrays.sort(arr);
        // int의 자릿수를 구함
        int len = (int)Math.log10(n) + 1;
        p = new String[len];
        max = 0;

        // 조합 구하기
        // 중복순열 : 순서를 고려하면서 서로 다른 n개에서 중복으로 r개를 일렬로 나열하는 수
        // 3자리수면 -> 1, 2, 3 자리수일 때 다 구해주기
        // 반례 : 100 3 -> 1 2 3 max = 33
        for (int i = len; i > 0; i--) {
            permutation(0, k, i);
        }

        bw.write(max + "");
        bw.flush();
        bw.close();
    }

    static void permutation(int depth, int N, int R){
        // r개를 다 고른 경우
        if (depth == R){
            // 배열에 담긴 순열을 문자열로 바꾸기
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < R; i++) {
                sb.append(p[i]);
            }
            // N보다 작은 값 중 최댓값 누적
            int now  = Integer.parseInt(sb.toString());
            if (n >= now){
                max = Math.max(max, now);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            // 1개씩 이어 붙인다
            p[depth] = arr[i];
            permutation(depth+1, N, R); // depth + 1 전달
        }
    }
}