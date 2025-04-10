import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Integer> q = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();

            switch (op){
                case "push":
                    int x = Integer.parseInt(st.nextToken());
                    q.addLast(x);
                    break;
                case "pop":
                    if (!q.isEmpty()){
                        bw.write(q.poll() + "\n");
                    }else{
                        bw.write("-1\n");
                    }
                    break;
                case "size":
                    bw.write(q.size() + "\n");
                    break;
                case "empty":
                    if (q.isEmpty()){
                        bw.write("1\n");
                    }else{
                        bw.write("0\n");
                    }
                    break;
                case "front":
                    if (!q.isEmpty()){
                        bw.write(q.getFirst() + "\n");
                    }else{
                        bw.write("-1\n");
                    }
                    break;
                case "back":
                    if (!q.isEmpty()){
                        bw.write(q.getLast() + "\n");
                    }else{
                        bw.write("-1\n");
                    }
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}