import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        // N/2 개를 가져감 -> 최대한 다른 종류
        // 그 종류 개수의 최댓값
        
        // 1. 다른 종류의 개수 세기
        // 종류별 개수를 저장 -> key: 종류 value: 개수
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        // 2. 개수의 최댓값
        // 최대 종류의 개수 = map의 크기(단, N/2보다 클 경우는 N/2가 최대)
        if (nums.length/2 < map.size()){
            answer = nums.length/2;
        }else{
            answer = map.size();
        }
        
        return answer;
    }
}