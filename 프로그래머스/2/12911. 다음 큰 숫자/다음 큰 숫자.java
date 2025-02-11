class Solution {
    public int solution(int n) {
        int answer = 0;

        // 1. n을 2진수로 변환 후 1의 갯수 새기
        int bN = Integer.bitCount(n);

        while(true){
            // 2. 1씩 증가
            n += 1;

            // 3. 2진수 변환 수 1의 개수 세기
            int cnt = Integer.bitCount(n);

            // 3. n의 1 개수와 같으면 break
            if (bN == cnt){
                answer = n;
                break;
            }
        }
        
        return answer;
    }
}