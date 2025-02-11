class Solution {
    public int solution(int n) {
        int answer = 0;

        // 1. n을 2진수로 변환 후 1의 갯수 새기
        String binaryN = Integer.toBinaryString(n);
        int bN = 0;
        for (int i = 0; i < binaryN.length(); i++) {
            if (binaryN.charAt(i) == '1'){
                bN++;
            }
        }
        
        while(true){
            // 2. 1씩 증가
            n += 1;

            // 3. 2진수 변환 수 1의 개수 세기
            String b = Integer.toBinaryString(n);
            int cnt = 0;
            for (int i = 0; i < b.length(); i++) {
                if (b.charAt(i) == '1'){
                    cnt++;
                }
            }
            
            // 3. n의 1 개수와 같으면 break
            if (bN == cnt){
                answer = n;
                break;
            }
        }
        
        return answer;
    }
}