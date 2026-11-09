import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        HashMap<String, Integer> wantMap = new HashMap<>();
        for(int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        int start = 0;
        int end = 10;
    
        while(end <= discount.length) {
            HashMap<String, Integer> curMap = new HashMap<>();
            // 현재 할인 항목 각 갯수
            for(int i = start; i < end; i++) {
                curMap.put(discount[i], curMap.getOrDefault(discount[i], 0) + 1);
            }
            
            int pass = 0;
            
            // want 랑 비교
            for (String w : want) {
                if(curMap.containsKey(w) && curMap.get(w).equals(wantMap.get(w))) {
                    pass++;
                }
            }
            
            if(pass == want.length) {
                answer += 1;
            }
            
            start++;
            end++;
            
        }
        
        return answer;
    }
}