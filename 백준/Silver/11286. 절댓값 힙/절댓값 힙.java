import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> pq = new PriorityQueue<>(new PriorityComparator());

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x == 0){
                if(pq.isEmpty()){
                    bw.write("0 \n");
                }else{
                    bw.write(pq.poll() + "\n");
                }
            }else{
                pq.add(x);
            }
        }
        bw.flush();
        bw.close();
    }

    static class PriorityComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            // 1 : 뒤로(더 큰 값), -1 : 앞으로(더 작은 값), 0 : 그대로(같은 값)
            if (Math.abs(o1) > Math.abs(o2)) {
                return 1;
            } else if(Math.abs(o1) < Math.abs(o2)){
                return -1;
            } else{
                if(o1 > o2){
                    return 1;
                }else if(o1 < o2){
                    return -1;
                }else {
                    return 0;
                }
            }
        }
    }
}