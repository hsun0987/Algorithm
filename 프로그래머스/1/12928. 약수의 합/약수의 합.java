import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // 제곱근
        double sqrt = Math.sqrt(n);
        ArrayList<Integer> list = new ArrayList<>();

        // 제곱근을 기준으로 좌우가 똑같기 때문에 절반만 반복
        for (int i = 1; i <= sqrt; i++) {
            if (n % i == 0) {
                // n
                if (Math.pow(i, 2) == n) { 
                    list.add(i);
                } else {
                    // i와 n/i 는 모두 n의 약수임
                    list.add(i);
                    list.add(n / i);
                }
            }
        }

        for (int i:list) {
            answer+= i;
        }
        
        return answer;
    }
}