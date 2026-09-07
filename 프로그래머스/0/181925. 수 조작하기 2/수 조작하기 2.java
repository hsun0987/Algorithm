class Solution {
    public String solution(int[] numLog) {
        String answer = "";
        
        // 다음 숫자 - 지금 숫자 = 결과 [w, s, d, a]

        for (int i = 0; i < numLog.length - 1; i++) {
            int op = numLog[i+1] - numLog[i];
            
            if (op == 1) {
                answer += "w";
            }else if (op == -1) {
                answer += "s";
            }else if (op == 10) {
                answer += "d";
            }else {
                answer += "a";
            }
        }
        return answer;
    }
}