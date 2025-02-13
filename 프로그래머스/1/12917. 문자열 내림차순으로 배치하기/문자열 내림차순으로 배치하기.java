import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        // s를 배열로 만들고 정렬 후 문자열 뒤집기
        // String[] 보다 char[] 로 해야 다시 String 으로 만들기 좋음
        char[] str = s.toCharArray();
        Arrays.sort(str);
        answer = new StringBuilder(new String(str)).reverse().toString();
        
        return answer;
    }
}