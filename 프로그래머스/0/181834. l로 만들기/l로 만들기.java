class Solution {
    public String solution(String myString) {
        String answer = "";
        
        for(int i = 0; i < myString.length(); i++){
            char now = myString.charAt(i);
            if(now < 'l'){
                answer += "l";
            }else{
                answer += now;
            }
        }
        
        return answer;
    }
}