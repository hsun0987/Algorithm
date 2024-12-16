class Solution {
    public static int[] solution(long n) {

        // 1. StringBuffer에 n을 문자열로 저장
        StringBuffer sb = new StringBuffer(String.valueOf(n));

        // 2. 문자열 뒤집기
        String[] reverse = sb.reverse().toString().split("");

        // 3. 배열로 반환
        int[] answer = new int[reverse.length];
        for (int i = 0; i < reverse.length; i++) {
            answer[i] = Integer.parseInt(reverse[i]);
        }

        return answer;
    }
}