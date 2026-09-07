class Solution {
    public long solution(int balls, int share) {
        long answer = 0; 
        
        answer = combination(balls, share);
        
        return answer;
    }
    public long combination(int n, int r){
        if(r == 0 || n == r) return 1; 
    
        return combination(n-1, r-1) + combination(n-1, r);
    }
}