import java.io.*;
import java.util.*;

public class Main {
    static int[] ans = new int[2];
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<Integer, Integer> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 좌표압축 : 넓은 범위의 좌표를 임의로 줄여줌

        // 원본 배열
        int[] arr = new int[n];
        // 정렬할 배열
        int[] sorted = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sorted[i] = Integer.parseInt(st.nextToken());
        }

        // 원본 배열을 정렬
        Arrays.sort(sorted);

        // 정렬한 배열에 대해 순위를 매김 => map(원래 숫자, rank)
        int rank = 0;
        for (int v: sorted) {
            // 이미 순위를 매긴 동일한 숫자는 제외
            if (!map.containsKey(v)){
                map.put(v, rank);
                rank++;
            }
        }

        // 원본 배열 순서대로 value(rank)를 가져옴
        for (int key : arr) {
            bw.write(map.get(key) + " ");
        }

        bw.flush();
        bw.close();
    }
}