import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        while(true){
            if (n < 10){
                answer += n;
                break;
            }

            answer += n % 10;
            n = n / 10;
        }
        
        return answer;
    }
}