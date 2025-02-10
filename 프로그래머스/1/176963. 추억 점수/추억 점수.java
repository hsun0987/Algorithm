import java.util.*;

class Solution {
    public ArrayList<Integer> solution(String[] name, int[] yearning, String[][] photo) {
        ArrayList<Integer> answer = new ArrayList<>();

        // 1. photo에 이름이 있는지 확인
        // 2. 이름에 해당하는 추억 점수 합산

        // (name, yearning) 의 hash map 생성
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        // photo에 있는 이름을 하나씩 map에 포함되어 있는지 확인 후 점수 합
        for(String[] p : photo){
            int sum = 0;
            for (String s : p) {
                if (map.containsKey(s)){
                    sum += map.get(s);
                }
            }
            answer.add(sum);
        }
        
        return answer;
    }
}