class Solution {
    public int solution(String name) {
        int answer = 0;

        // 상하 이동 (알파벳)
        for (char a : name.toCharArray()) {
            answer += Math.min(a - 'A' , 'Z' - a + 1);
        }

        // 좌우 이동
        int len = name.length();
        int move = name.length() - 1;

        for (int i = 0; i < len; i++) {
            int next = i + 1;
            while (next < len && name.charAt(next) == 'A') {
                next++;
            }

            int min = Math.min(i * 2 + (len - next), (len - next) * 2 + i);
            move = Math.min(min, move);
        }

        answer += move;
        
        return answer;
    }
}