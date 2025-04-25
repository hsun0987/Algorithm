import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            String str = br.readLine();
            StringBuilder sb = new StringBuilder(str);
            if (str.equals("0")){
                break;
            }
            sb.reverse();
            if (str.equals(sb + "")){
                bw.write("yes \n");
            }else{
                bw.write("no \n");
            }
        }

        bw.flush();
        bw.close();
    }
}