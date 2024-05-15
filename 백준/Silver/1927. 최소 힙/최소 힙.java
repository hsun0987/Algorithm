import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> arr = new PriorityQueue<>();
        
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
        	int num = Integer.parseInt(br.readLine());
            if(num == 0) {
        		if(arr.isEmpty()) {
        			bw.write("0 \n");
        		}else {
        			bw.write(arr.poll() + "\n");
        		}
        	}else {
        		arr.add(num);
        	}
        }
        bw.flush();
        bw.close();
    }
}