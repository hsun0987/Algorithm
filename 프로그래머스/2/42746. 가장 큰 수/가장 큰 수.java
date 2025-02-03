import java.util.*;

class Solution {
    public StringBuilder solution(int[] numbers) {
        
        // 문자열로 바꿔서 저장
        String[] str = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }

        // 내림차순 정렬
        // o1 : 10, o2 : 2 이면 102과 210 중 뭐가 더 큰지 비교
        Arrays.sort(str, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        
        // 문자열을 합치는 연산을 할 때 String 보다 성능이 좋음
        StringBuilder answer = new StringBuilder();
        
        // 첫번째 값 = 0, 0으로만 이루어진 배열 -> 0 리턴
        if (str[0].equals("0")){
            return answer.append("0");
        }

        for (String s : str){
            answer.append(s);
        }
        
        return answer;
    }
}