import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            // ACGT 순서대로 빈도수 저장
            int[] count = new int[4];

            for (int j = 0; j < n; j++) {
                char c = arr[j].charAt(i);

                switch (c) {
                    case 'A':
                        count[0]++;
                        break;
                    case 'C':
                        count[1]++;
                        break;
                    case 'G':
                        count[2]++;
                        break;
                    case 'T':
                        count[3]++;
                        break;
                }
            }

            int max = 0;
            int idx = 0;
            for (int j = 0; j < 4; j++) {
                if (count[j] > max){
                    max = count[j];
                    idx = j;
                }
            }

            if (idx == 0){
                sb.append("A");
            } else if (idx == 1) {
                sb.append("C");
            }else if (idx == 2){
                sb.append("G");
            }else {
                sb.append("T");
            }

        }
        
        // 해밍거리 구하기 = 서로 다른 문자의 갯수
        // 서로 다른 문자가 나올 때 ++
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i].charAt(j) != sb.charAt(j))
                    answer++;
            }
        }

        bw.write(sb + "\n");
        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
}