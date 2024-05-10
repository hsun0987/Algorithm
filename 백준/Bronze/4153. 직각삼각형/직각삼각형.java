import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // a^2 = b^2 + c^2
        while (true){
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            if (a == 0 && b == 0 && c == 0){
                break;
            }

            if (a*a == (b*b + c*c)) {
                bw.write("right \n");
            } else if (b*b == (a*a + c*c)) {
                bw.write("right \n");
            } else if (c*c == (a*a + b*b)) {
                bw.write("right \n");
            } else{
                bw.write("wrong \n");
            }
        }

        bw.flush();
        bw.close();
    }
}