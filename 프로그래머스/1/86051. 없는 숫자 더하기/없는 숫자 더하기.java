import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        // i = 0~9 numbers 배열 안에 숫자가 포함되는지 확인
        // 배열은 하나씩 비교-> 효율성 떨어짐 => arraylist에 넣음
        
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }

        for (int i = 0; i < 10; i++) {
            if (!list.contains(i)){
                answer += i;
            }
        }
        
        return answer;
    }
}