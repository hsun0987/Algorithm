import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        int[] arr = new int[number+1]; 
        
        for(int i = 1; i <= number; i++) {
            HashSet<Integer> set = new HashSet<>(); // 약수 중복제거
            for(int k = 1; k <= i; k++) {
                if(i % k == 0) {
                    set.add(k);
                }
            }
            arr[i] = set.size();
        }
        
        for(int a : arr) {
            if (a <= limit) {
                answer += a;
            } else {
                answer += power;
            }
        }
        
        return answer;
    }
}