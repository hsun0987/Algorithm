import java.io.*;
import java.util.*;

public class Main {
    static int L, C;
    static char[] alpha;
    static ArrayList<String> answer;
    static char[] temp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());


        alpha = br.readLine().replace(" ","").toCharArray();
        Arrays.sort(alpha);

        answer = new ArrayList<>();
        temp = new char[L];
        dfs(0, 0);

        for(String str: answer){
            bw.write(str + "\n");
        }

        bw.flush();
        bw.close();
    }

    static void dfs(int depth, int start){
        if (depth == L){
            // 1 이상 모음, 2 이상 자음 포함
            int mo = 0, ja = 0;
            for (char ch : temp) {
                if("aeiou".indexOf(ch) >= 0) mo++; // indexOf : 문자가 있음 인덱스번호 반환, 없으면 -1
                else ja++;
            }

            if (mo >= 1 && ja >= 2){
                answer.add(new String(temp));
            }
            return;
        }

        for (int i = start; i < C; i++) {
            temp[depth] = alpha[i];
            dfs(depth+1, i+1);
        }
    }
}