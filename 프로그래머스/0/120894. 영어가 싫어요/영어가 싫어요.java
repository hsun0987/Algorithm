import java.util.*;

class Solution {
    public long solution(String numbers) {
        long answer = 0;
        
        // 1. 해시맵에 <one, 1> 로 저장
        // 2. 문자열을 하나씩 잘라붙여서 맵에 있는지 확인
        // 3. 있으면 맵의 value를 답에 붙임
        
        HashMap<String, String> map = new HashMap<>();
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");
        
        StringBuilder sb = new StringBuilder();
        int j = 0;
        // 최소가 세글자 이상이니까 3부터
        for (int i = 3; i < numbers.length()+1; i++) {
            String s = numbers.substring(j, i);
            if (map.containsKey(s)){
                sb.append(map.get(s));
                j = i;
            }
        }
        
        answer = Long.parseLong(sb.toString());
        
        
        return answer;
    }
}