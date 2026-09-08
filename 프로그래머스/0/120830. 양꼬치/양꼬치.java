class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        answer = n * 12000;
        
        if (n/10 > 0) {
            k = (k - (n/10));
        } 
        
        answer += k * 2000;
        
        return answer;
    }
}