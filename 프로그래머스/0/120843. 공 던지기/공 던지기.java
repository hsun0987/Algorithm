class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 1;

        // 1. 공을 다음 던지는 사람 = 현재 + 2
        // 2. 그 값이 총 인원 수보다 크면 -len

        int len = numbers.length;
        for (int i = 0; i < k-1; i++) {
            answer += 2;
            if (answer > len){
                answer -= len;
            }
        }
        
        return answer;
    }
}