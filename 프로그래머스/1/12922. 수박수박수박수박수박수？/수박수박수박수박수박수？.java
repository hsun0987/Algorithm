class Solution {
    public String solution(int n) {
        String answer = "";
        
        for (int i = 1; i < n+1; i++) {
            if (i % 2 == 1) {
                // 1. i가 홀수 = '수'
                answer += "수";
            } else {
                // 2. i가 짝수 = '박'
                answer += "박";
            }
        }
        
        return answer;
    }
}