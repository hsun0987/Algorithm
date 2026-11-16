class Solution {
    public String solution(String s) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
        
        int k = 0; // 단어 인덱스
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                sb.append(" ");
                k = 0; // 공백이면 다시 단어 0부터 시작
                continue;
            }
            
            if(k % 2 == 0){ // 짝수
                sb.append((s.charAt(i) + "").toUpperCase());
            } else {
                sb.append((s.charAt(i) + "").toLowerCase());
            }
            k++;
        }
        
        answer = sb.toString() + "";
        return answer;
    }
}