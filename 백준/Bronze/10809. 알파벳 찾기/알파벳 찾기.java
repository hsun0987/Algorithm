import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 알파벳 배열 만들기
        HashMap<Character, Integer> map = new HashMap<>(){
            {
                put('a', -1);
                put('b', -1);
                put('c', -1);
                put('d', -1);
                put('e', -1);
                put('f', -1);
                put('g', -1);
                put('h', -1);
                put('i', -1);
                put('j', -1);
                put('k', -1);
                put('l', -1);
                put('m', -1);
                put('n', -1);
                put('o', -1);
                put('p', -1);
                put('q', -1);
                put('r', -1);
                put('s', -1);
                put('t', -1);
                put('u', -1);
                put('v', -1);
                put('w', -1);
                put('x', -1);
                put('y', -1);
                put('z', -1);
            }
        };

        String str = br.readLine();
        // 2. 입력된 문자열의 한 글자씩 있는지 확인
        for (int i = 0; i < str.length(); i++) {
            if(map.get(str.charAt(i)) == -1){
                map.replace(str.charAt(i), i);
            }
        }
        for (char key : map.keySet()){
            bw.write(map.get(key) + " ");
        }
        bw.flush();
        bw.close();
    }
}