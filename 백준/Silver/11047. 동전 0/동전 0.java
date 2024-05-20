import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int answer = 0;

        // 동전의 종류
        ArrayList<Integer> coins = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            coins.add(Integer.parseInt(br.readLine()));
        }
        // 1. 동전의 종류가 큰 값부터 비교하기 위해 내림차순 정렬
        Collections.reverse(coins);
        
        // 2. 동전의 개수 구하기
        // - k 값으로 만들기 위한 cur
        int cur = 0;
        for (int coin : coins) {
            // 4200 - 0 < 50000
            if(k - cur < coin){
                continue;
            }
            // 1000원으로 바꿀 수 있을 만큼 계속 반복
            // 4200 - 0 > 1000
            // cur + 1000 * 4;
            while(k - cur >= coin){
                cur += coin;
                answer++;
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
}