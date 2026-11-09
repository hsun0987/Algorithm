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
        
        HashMap<String, Integer> curMap = new HashMap<>();
        // 현재 할인 항목 각 갯수
        for(int i = start; i < end; i++) {
            curMap.put(discount[i], curMap.getOrDefault(discount[i], 0) + 1);
        }
    
        while(true) {
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
            
            if(end >= discount.length) {
                break;
            }
                
                
            // start + 1 -> 왼쪽 제거
            curMap.put(discount[start] , curMap.get(discount[start]) - 1);
            start++;

            // end + 1 -> 오른쪽 추가
            curMap.put(discount[end] , curMap.getOrDefault(discount[end] , 0) + 1);
            end++;
            
        }
        
        return answer;
    }
}