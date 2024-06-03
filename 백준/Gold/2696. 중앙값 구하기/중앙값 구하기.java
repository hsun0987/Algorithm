import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int t = Integer.parseInt(br.readLine());
        while (t --> 0){
            int n = Integer.parseInt(br.readLine());
            // 중앙값 배열
            ArrayList<Integer> answer = new ArrayList<>();
            // 중앙값 개수
            bw.write(((n+1) / 2) + "\n");
            // 출력 줄 간격 띄우기에 사용
            int cnt = 0;
            
            for (int i = 0; i < n; i++) {
                if(i % 10 == 0){
                    // 10개씩 한줄에 입력 받아서
                    st = new StringTokenizer(br.readLine());
                }
                // 값을 1개씩 배열에 넣음
                int x = Integer.parseInt(st.nextToken());
                answer.add(x);
                // 넣을 때마다 오름차순 정렬
                Collections.sort(answer);

                // i가 홀수 일 때마다 중앙 값 구하기(i=0 부터 시작이니까 짝수)
                if(i % 2 == 0){
                    // 한줄에 10개씩만 출력
                    if(cnt != 0 && cnt % 10 == 0){
                        bw.write( "\n");
                    }
                    bw.write(answer.get(i / 2) + " ");
                    cnt++;
                }
                if (i == n-1){
                    // 다음 테스트 케이스를 위해 줄바꿈
                    bw.write("\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }
}