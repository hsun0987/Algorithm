import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        // 투포인터 이용
        // 1. 보석의 개수 구하기
        // 2. hash map -> 보석의 종류와 개수
        // 3. start, end 범위 지정
        //  - 보석의 개수가 적으면 범위 늘리기 end ++
        //  - 보석이 다 모이면 최소 길이, 범위 갱신/ 범위 줄이기 start++
        
        Set<String> set = new HashSet<>();
        for(int i = 0; i < gems.length; i++){
            set.add(gems[i]);
        }
        
        int total = set.size();
        int start = 0, end = 0;
        int len = Integer.MAX_VALUE;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        while(true){
            if(map.size() == total){    // 보석 종류 다 모으면
                // 길이와 구간 갱신(최소일 경우만)
                if(end - start < len){
                    len = end - start;
                    answer[0] = start + 1;
                    answer[1] = end;
                }
                // 범위 줄이기(보석 제거)
                String gem = gems[start];
                map.put(gem, map.get(gem) -1);
                if(map.get(gem) == 0){
                    map.remove(gem);
                }
                start++;
            }else{
                if(end == gems.length){
                    break;
                }
                // 범위 늘리기(보석 추가)
                String gem = gems[end];
                map.put(gem, map.getOrDefault(gem, 0) + 1);
                end++;
            }
        }
        
        
        return answer;
    }
}