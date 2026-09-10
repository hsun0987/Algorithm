class Solution {
    public int solution(String name) {
        int answer = 0;
        // 알파벳 변경 횟수 최소 -> 정해진 횟수가 있음
        int aMin = 0;
        int first = 65;
        int last = 90 + 1;
        for (char i : name.toCharArray()) {
           aMin += Math.min(i - first, last - i);
        }

        // 오른쪽으로 이동하는 경우
        int move = name.length() - 1;

        for (int i = 0; i < name.length(); i++) {

            int index = i + 1; // 다음 값 확인
            int length = name.length();

            // 연속된 A 개수 확인
            while (index < length && name.charAt(index) == 'A') {
                index++;
            }

            // 중간에 방향을 바꾸는 경우
            // 왼쪽 → 오른쪽 : 0 → i → 0 → index
            // 오른쪽 → 왼쪽 : len → index → len → i
            int lr = Math.min(i * 2 + (length - index), (length - index) * 2 + i );

            move = Math.min(move, lr);

        }
        
        answer = aMin + move;
        return answer;
    }
}