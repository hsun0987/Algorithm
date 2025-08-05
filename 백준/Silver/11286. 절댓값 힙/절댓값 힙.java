import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int abs1 = Math.abs(o1);
                int abs2 = Math.abs(o2);

                if (abs1 == abs2){ // 더 작은 값이 먼저
                    return o1 - o2;
                }else{
                    return abs1 - abs2;
                }
            }
        });

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0){
                if (pq.isEmpty()){
                    bw.write("0 \n");
                    continue;
                }
                bw.write(pq.poll() + "\n");
            }else{
                pq.add(input);
            }
        }

        bw.flush();
        bw.close();
    }
}