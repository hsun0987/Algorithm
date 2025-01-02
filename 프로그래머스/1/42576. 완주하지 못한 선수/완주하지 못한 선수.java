import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        // 완주자 명단에 없는 사람의 이름 반환 -> 동명이인 고려
        
        // 1. key: 이름 value: 동명이인 개수
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            map.put(participant[i], map.getOrDefault(participant[i], 0) + 1);
        }
        
        // 2. 완주자에 key가 있으면 value -1
        for (String name : completion){
            map.put(name, map.get(name) -1);
        }
        
        // 3. value가 1인 key 값 리턴
        for(String key: map.keySet()){
            if (map.get(key) == 1){
                answer = key;
            }
        }
        
        return answer;
    }
}