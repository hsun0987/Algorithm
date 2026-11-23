import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        for(String[] s : clothes) {
            if(!map.containsKey(s[1])) {
                map.put(s[1], new ArrayList<>());
            } 
            map.get(s[1]).add(s[0]);
        }
        
        for(String key : map.keySet()) {
            answer *= map.get(key).size() + 1;
        }
        
        return answer - 1;
    }
}




