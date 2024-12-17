class Solution {
    public String solution(String s) {
        String answer = "";
        
        int idx = s.length()/2;

        // 1. 단어의 길이 홀수 => n/2 + 1
        if (s.length() % 2 == 1){
            answer = s.substring(idx, idx+1);
        }
        // 2. 단어의 길이 짝수 => n/2 부터 2개
        else{
            answer = s.substring(idx-1,idx+1);
        }

        return answer;
    }
}