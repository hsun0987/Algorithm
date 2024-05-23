import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 노드의 인덱스 번호로 접근하기 위해서 Queue 대신 LinkedList 사용
        LinkedList<int[]> q;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            q = new LinkedList<>();

            String[] arr = br.readLine().split(" ");
            // 1. 중요도 큐에 삽입
            for (int j = 0; j < n; j++) {
                q.add(new int[]{j, Integer.parseInt(arr[j])});
            }

            int answer = 0;

            // 2. 앞에서 부터 꺼내 봤을 때 중요도가 크면 먼저 꺼내기
            while(!q.isEmpty()){
                // 1. 첫번째 원소 pop
                int[] node = q.poll();
                // 가장 큰 값인지 확인
                boolean isMax = true;

                for (int j = 0; j < q.size(); j++) {
                    // 2. q에서 꺼낸 원소보다 큰 값이 있으면
                    if(node[1] < q.get(j)[1]){
                        q.add(node);
                        // 그 값 앞에 있는 원소들 다 뒤로 배치
                        for (int k = 0; k < j; k++) {
                            q.add(q.poll());
                        }
                        // 가장 큰 값이 아니라는 뜻이므로
                        isMax = false;
                        break;
                    }
                }

                if(!isMax){
                    continue;
                }

                // 3. node가 가장 큰 값일 때
                answer++;

                // 그 값이 찾는 값과 같으면 break
                if(node[0] == m){
                    break;
                }

            }

            bw.write(answer + "\n");
        }


        bw.flush();
        bw.close();
    }
}