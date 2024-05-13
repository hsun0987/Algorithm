import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        
        String[] arr = br.readLine().split(" ");
        int[] sums = new int[n];
        sums[0] = Integer.parseInt(arr[0]);
        for(int i = 1; i < n; i++) {
        	sums[i] += sums[i-1] + Integer.parseInt(arr[i]);
        }
        for(int i = 0; i < m; i++) {
        	String[] num = br.readLine().split(" ");
        	int start = Integer.parseInt(num[0]) - 1;
        	int end = Integer.parseInt(num[1]) - 1;
        	int answer;
        	if(start == 0) {
        		answer = sums[end];
        	}else {
        		answer = sums[end] - sums[start-1];
        	}
        	bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
    }
}