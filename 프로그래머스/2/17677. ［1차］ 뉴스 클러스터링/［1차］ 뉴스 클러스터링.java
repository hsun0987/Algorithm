import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0; 
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        
        for(int i = 0; i < str1.length() - 1; i++) {
            // 영문자 쌍이 아닌 경우 건너띄기
            String temp = str1.substring(i, i+2);
            
            if(temp.charAt(0) < 'a' || temp.charAt(0) > 'z'
               || temp.charAt(1) < 'a' || temp.charAt(1) > 'z') {
                continue;
            }
            
            list1.add(temp);
        }
        
        for(int i = 0; i < str2.length() - 1; i++) {
            String temp = str2.substring(i, i+2);
                
            if(temp.charAt(0) < 'a' || temp.charAt(0) > 'z'
               || temp.charAt(1) < 'a' || temp.charAt(1) > 'z') {
                continue;
            }
            list2.add(temp);
        }
        
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        
        for(String l : list1) {
            map1.put(l, map1.getOrDefault(l, 0) + 1);
        }
        
        for(String l : list2) {
            map2.put(l, map2.getOrDefault(l, 0) + 1);
        }
        
        HashSet<String> keys = new HashSet<>();

        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());
        
        double min = 0; // 교집합
        double max = 0; // 합집합
        
        for (String key : keys) {
            int cnt1 = map1.getOrDefault(key, 0);
            int cnt2 = map2.getOrDefault(key, 0);
            
            min += Math.min(cnt1, cnt2);
            max += Math.max(cnt1, cnt2);
        }
        
        double temp = 1;
        if (max > 0) {
            temp = min/max;
        }
        
        answer = (int)((temp) * 65536);
        
        return answer;
    }
}
