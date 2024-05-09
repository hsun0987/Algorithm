import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n1 = Integer.parseInt(input[0]);
        int n2 = Integer.parseInt(input[1]);

        int gcd;
        int lcm = n1 * n2;

        while(n2 > 0){
            int r = n1 % n2;
            n1 = n2;
            n2 = r;
        }
        gcd = n1;
        lcm = lcm / gcd;

        bw.write(gcd + "\n");
        bw.write(lcm + "\n");
        bw.flush();
        bw.close();
    }
}