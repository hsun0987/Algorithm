import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while(true) {
            String s = sc.next();
            boolean flag = true;

            if(s.equals("0")){
                break;
            }

            for (int i = 0; i < s.length()/2; i++) {
                if(s.charAt(i) != s.charAt(s.length()-i -1)) {
                    sb.append("no").append("\n");
                    flag = false;
                    break;
                }
            }
            if(flag) {
                sb.append("yes").append("\n");
            }
        }
        System.out.println(sb);
    }
}