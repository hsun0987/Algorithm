import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;

        // 1. key: 의상 카테고리 value: 개수
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }

        // 2. 경우의 수 = (의상 개수 + 1(안 입는 경우))의 곱 - 1(전부 안입는 경우)
        for (String key: map.keySet()){
            answer *= map.get(key) + 1;
        }

        answer -= 1;
        
        return answer;
    }
}