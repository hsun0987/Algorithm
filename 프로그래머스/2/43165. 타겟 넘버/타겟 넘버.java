class Solution {
    int[] numbers;
    int target;
    int answer;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        this.numbers = numbers;
        this.target = target;

        dfs(0, 0);
        
        return answer;
    }

    public void dfs (int depth, int current) {
        // numbers 의 길이랑 똑같을 때
        if (depth == numbers.length) {
            if(current == target) {
                answer++;
            }
            return;
        }

        // +, - 별 계산/결과
        dfs(depth + 1, current + numbers[depth]);
        dfs(depth + 1, current - numbers[depth]);  
    }
}