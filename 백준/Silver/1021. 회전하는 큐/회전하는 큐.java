import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<Integer> dq = new LinkedList<>();
        Queue<Integer> find = new LinkedList<>();

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            find.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i <= n; i++) {
            dq.add(i);
        }

        int answer = 0;
        while(true){
            if(find.isEmpty()){
                break;
            }
            // 1. 첫번째 원소가 찾는 원소가 같을 때
            if(find.peek().equals(dq.getFirst())){
                find.poll();
                dq.pollFirst();
                continue;
            }
            // 2. 찾는 원소가 왼쪽과 가까울 때
            if(dq.indexOf(find.peek()) <= dq.size()/2 ){
                while(!find.peek().equals(dq.getFirst())){
                    dq.addLast(dq.pollFirst());
                    answer++;
                }
                dq.pollFirst();
            }else{
                // 3. 찾는 원소가 오른쪽과 가까울 때
                while(!find.peek().equals(dq.getLast())){
                    dq.addFirst(dq.pollLast());
                    answer++;
                }
                dq.pollLast();
                answer++;
            }
            find.poll();
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
}