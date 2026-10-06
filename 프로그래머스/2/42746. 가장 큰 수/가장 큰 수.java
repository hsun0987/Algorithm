import java.util.*;

class Solution {
    public String solution(int[] numbers) { 
        String answer = "";

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(String.valueOf(numbers[i]));
        }
        
        // 정수를 문자열로 비교하여 정렬 30 vs 9 -> 9
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                // 문자열 하나씩 비교 (앞 문자를 기준으로 정렬)
                return (b+a).compareTo(a+b);
            }
        });
        
        // 반례 "000" -> "0"
        if (list.get(0).equals("0")) {
            return "0";
        }

        for (String a : list) {
            answer += a;
        }
        return answer;
    }
}