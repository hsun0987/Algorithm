import java.util.*;

class Solution {
    public String solution(int n) {
        String answer = "";
        
        // 1, 2, 4 숫자 반복
        // 2자리 수 이상일 수 있음
        // 뒷자리 수부터 %3 = 0, 1, 2
        // 앞자리 수는 /3
        
        int[] arr = new int[]{4, 1, 2};
        StringBuilder sb = new StringBuilder();
        
        while(n > 0){
            int a = n % 3;
            n = (n-1) / 3;
            
            sb.append(arr[a]);
        }
        
        answer = sb.reverse().toString();
    
        return answer;
    }
}