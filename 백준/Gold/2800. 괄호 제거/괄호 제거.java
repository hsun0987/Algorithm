import java.io.*;
import java.util.*;

public class Main {
    static List<int[]> list;
    static Set<String> result;
    static boolean[] check;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 괄호의 쌍을 찾기 위한 스택
        Stack<Integer> stack = new Stack<>();
        // 괄호의 쌍을 위치로 저장할 리스트
        list = new ArrayList<>();

        char[] input = br.readLine().toCharArray();
        // 1. 괄호 쌍의 위치를 인덱스번호로 저장
        for (int i = 0; i < input.length; i++) {
            // 괄호의 위치를 인덱스번호로 저장
            char c = input[i];
            if(c == '('){
                stack.push(i);
            } else if (c == ')') {
                // 끝 괄호를 만났을 때 처음 괄호의 인덱스와 함께 리스트에 저장
                list.add(new int[]{stack.pop(), i});
            }
        }

        // 결과값을 저장할 TreeSet -> 중복제거를 위해 사용
        result = new TreeSet<>();
        // 조합에 사용했는지 확인하기 위한 배열
        check = new boolean[input.length];
        // 입력한 값의 0번째부터 조합하는 메서드
        comb(0, input);

        for (String s : result) {
            System.out.println(s);
        }
    }
    
    static void comb(int idx, char[] str ){
        // 2. 리스트에서 제거할 괄호 뽑기 -> 조합이용
        // 괄호가 다 사용되었을 때 조합 저장
        if(idx == list.size()){
            // 중복이 있는지 확인
            boolean tf = false;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length; i++) {
                // 3. 제거할 괄호 인덱스를 제외한 문자열을 새로운 문자열로 만들기
                if(!check[i]){
                    // 포함이 되어있지 않은 문자라면
                    sb.append(str[i]);
                }else{
                    tf = true;
                }
            }
            if(tf){
                // 3. TreeSet에 저장 -> 중복 제거
                result.add(sb.toString());
            }
            return;
        }

        int[] getList = list.get(idx);
        // 리스트의 괄호를 포함하지 않은 경우 (check = true)
        check[getList[0]] = true;
        check[getList[1]] = true;
        comb(idx+1, str);

        // 리스트의 괄호를 포함한 경우 (check = false)
        check[getList[0]] = false;
        check[getList[1]] = false;
        comb(idx+1, str);
    }
}