import java.io.*;
import java.util.*;

public class Main {
    static String[] arr;
    static String[] p;
    static int max;
    static int num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String n = st.nextToken();
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new String[k];
        for (int i = 0; i < k; i++) {
            arr[i] = st.nextToken();
        }

        Arrays.sort(arr);
        p = new String[n.length()];
        max = 0;
        num = Integer.parseInt(n);
        // 조합 구하기
        // 중복순열 : 순서를 고려하면서 서로 다른 n개에서 중복으로 r개를 일렬로 나열하는 수
        // 3자리수면 -> 1, 2, 3 자리수일 때 다 구해주기
        // 반례 : 100 3 -> 1 2 3 max = 33
        for (int i = n.length(); i > 0; i--) {
            permutation(0, k, i);
        }


        bw.write(max + "");
        bw.flush();
        bw.close();
    }

    static void permutation(int depth, int n, int r){
        // r개를 다 고른 경우
        if (depth == r){
            // 배열에 담긴 순열을 문자열로 바꾸기
            String str = "";
            for (int i = 0; i < r; i++) {
                str += p[i];
            }
            // N보다 작은 값 중 최댓값 누적
            int now  = Integer.parseInt(str);
            if (num >= now){
                max = Math.max(max, now);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            // 1개씩 이어 붙인다
            p[depth] = arr[i];
            permutation(depth+1, n, r); // depth + 1 전달
        }

    }
}