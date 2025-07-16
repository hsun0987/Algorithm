import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        // 1. 명단 hash map 생성 -> 동명이인을 고려하여 value 에 인원수 저장
        // 2. completion 에 이름이 있을 경우 value -1
        // 3. value != 0 일 경우 완주하지 못한 사람
        
        HashMap<String, Integer> map = new HashMap<>();
        for(String name : participant){
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        
        for(String name : completion){
            map.put(name, map.get(name) - 1);
            
            if(map.get(name) == 0){
                map.remove(name);
            }
        }
        
        for(String name : map.keySet()){
            answer = name;
        }
        return answer;
    }
}