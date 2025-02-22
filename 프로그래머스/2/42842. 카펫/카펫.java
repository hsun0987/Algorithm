class Solution {
    static int n, m;
    
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
         // 1. 노랑의 격자배열을 1줄, 2줄 3줄 .. 차례로 탐색
        // 2. 필요한 갈색 개수가 같다면 정답
        // - 노랑 격자(n*m) --> (n+m)*2+4 = 갈색 개수
        // 3. 전체 크기 = n+2, m+2

        n = 1;
        m = yellow / n;

        while (!isBrown(brown, yellow)){
            isBrown(brown, yellow);
        }

        answer[0] = Math.max(n+2, m+2);
        answer[1] = Math.min(n+2, m+2);

        return answer;
    }

    public static boolean isBrown(int b, int y) {
        if (((n + m) * 2 + 4) != b){
            n += 1;
            // 직사각형 -> 약수로 격자 만듦
            while (y % n != 0){
                n += 1;
            }
            m = y / n;
            return false;
        }else{
            return true;
        }
    }
}