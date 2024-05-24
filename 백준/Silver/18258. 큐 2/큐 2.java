import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<Integer> q = new LinkedList<>();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            switch (input[0]){
                case "push":
                    q.add(Integer.parseInt(input[1]));
                    break;
                case "pop":
                    if(q.isEmpty()){
                        bw.write("-1 \n");
                        break;
                    }
                    bw.write(q.poll() +"\n");
                    break;
                case "size":
                    bw.write(q.size() + "\n");
                    break;
                case "empty":
                    if(q.isEmpty()){
                        bw.write("1 \n");
                    }else
                        bw.write("0 \n");
                    break;
                case "front":
                    if(q.isEmpty()){
                        bw.write("-1 \n");
                        break;
                    }
                    bw.write(q.getFirst() + "\n");
                    break;
                case "back":
                    if(q.isEmpty()){
                        bw.write("-1 \n");
                        break;
                    }
                    bw.write(q.getLast() + "\n");
                    break;
            }
        }

        bw.flush();
        bw.close();
    }
}