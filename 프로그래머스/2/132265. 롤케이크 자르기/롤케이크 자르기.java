// 20
import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        HashMap<Integer, Integer> one = new HashMap<>();
        HashMap<Integer, Integer> two = new HashMap<>();
        
        int start = 0;
        int mid = 1; // -> 증가
        int end = topping.length;
        
        // map 초기 값 저장
        one.put(topping[0], 1);
        
        for(int i = mid; i < end; i++) {
            two.put(topping[i], two.getOrDefault(topping[i], 0) + 1);
        }

        while(mid < end) {
            // 1, 2 map 크기 비교
            if(one.size() == two.size()) {
                answer++;
            }
            
            // mid + 1씩 증가 -> 1 증가, 2 제거
            one.put(topping[mid], one.getOrDefault(topping[mid], 0) + 1);
            two.put(topping[mid], two.get(topping[mid]) - 1); 
            // 만약에 갯수가 0인 경우는 제거해야됨
            if (two.get(topping[mid]) == 0) {
                two.remove(topping[mid]);
            }
            
            mid++;
        }
        return answer;
    }
}