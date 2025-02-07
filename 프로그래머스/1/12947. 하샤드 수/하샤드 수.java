class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        // x값 변경 방지
        int a = x;
        int num = 0;
        while(true){
            if(a < 10){
                num += a;
                break;
            }

            num += a%10;
            a = a/10;
        }

        if(x % num != 0){
            answer = false;
        }
        
        return answer;
    }
}