import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        
        // value 내림차순 정렬
        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));

        int sum = 0;
        for (int key : keySet) {
            if (sum < k) {
                sum += map.get(key);
                answer++;
            } 
        } 
        
        return answer;
    }
}