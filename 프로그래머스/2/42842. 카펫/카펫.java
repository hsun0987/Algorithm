class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        // 1. 전체 크기 = brown + yellow 의 약수
        // 2. yellow 개수와 적합한 크기 찾기
        // - 가로 = 합 / i (i = 세로), yellow = (가로-2) * (세로-2)

        // 최소 크기 = 3 (y=1 일 때)
        for (int i = 3; i < brown+yellow ; i++) {
            int width = (brown + yellow) / i;
            if (width >= i){ // 가로가 더 길다
                if (yellow == (width-2) * (i-2)){
                    answer[0] = width;
                    answer[1] = i;
                    break;
                }
            }
        }
        
        return answer;
    }
}