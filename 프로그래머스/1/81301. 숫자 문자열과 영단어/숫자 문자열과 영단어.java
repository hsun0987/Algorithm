import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>() {
            { 
                put("zero", 0);
                put("one", 1);
                put("two", 2);
                put("three", 3);
                put("four", 4);
                put("five", 5);
                put("six", 6);
                put("seven", 7);
                put("eight", 8);
                put("nine", 9);
            }
        };
        String temp = "";
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 1. 숫자가 아니면 문자열 합치기
            if (!Character.isDigit(s.charAt(i))) {
                temp += s.charAt(i);
            }else {
                // 숫자면 결과 문자열에 붙이기
                res += s.charAt(i);
            }
            
            
            // 2. map에 포함되어있으면 숫자로 변형 후 String 리셋
            if (map.containsKey(temp)) {
                res += map.get(temp);
                temp = "";
            }
            
        } 
        
        answer = Integer.parseInt(res);
        
        return answer;
    }
}