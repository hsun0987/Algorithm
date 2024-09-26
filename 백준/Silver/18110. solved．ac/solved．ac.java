import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 1. 정렬
        Arrays.sort(arr);

        // 2. 총 인원 * 15% → 반올림
        int out = (int)(Math.round(n * 0.15) / 1.0);

        // 3. 가장 낮은 사람 2번명, 가장 높은 사람 2번명 제외
        int sum = 0;
        for (int i = out; i < n - out; i++) {
            sum += arr[i];
        }

        // 4. 나머지 사람들의 평균 → 반올림
        // 나눗셈할 때 한쪽이 double이어야지 소숫점 이하가 나옴 !!
        int answer = (int)(Math.round((double)sum / (n-(out*2))) / 1.0);

        bw.write(answer + " ");

        bw.flush();
        bw.close();
    }
}