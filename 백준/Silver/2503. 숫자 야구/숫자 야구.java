import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<String> list = new ArrayList<>();
        // 1. 모든 가능한 3자리 수 후보 만들기
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    // 세자리 수가 모두 다르면
                    if (i != j && j != k && k != i){
                        list.add("" + i + j + k);
                    }
                }
            }
        }

        // 2. 입력된 질문 기억하기
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            // for(i : list) 로 할 경우 반복문 중 리스트가 삭제되어 오류 발생
            // j++ 주의
            for(int j = 0; j < list.size(); ){
                // 3. 모든 후보를 입력값과 비교
                // -> 각 후보를 s, b 수를 구하고 아니면 제거
                String num = list.get(j);
                int ns = 0;
                int nb = 0;

                for (int k = 0; k < 3; k++) {
                    // 숫자가 같고 위치가 같으면 스트라이크
                    if (num.charAt(k) == input.charAt(k)){
                        ns++;
                    }else if(input.contains(String.valueOf(num.charAt(k)))){
                        // input에 숫자가 포함되어 있으면 볼
                        nb++;
                    }
                }

                // 주어진 s,b의 갯수와 다르면 배열에서 제거
                if (ns != strike || nb != ball){
                    list.remove(j);
                }else{
                    // 조건이 맞으면 다음 후보로
                    j++;
                }
            }
        }

       // 남은 후보 출력
        bw.write(list.size() + "");

        bw.flush();
        bw.close();
    }
}