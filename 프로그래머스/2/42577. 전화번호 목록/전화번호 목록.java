import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        // 한 번호가 다른 번호의 접두사
        // 1. key: 전화번호 value: x => Hash set 이용
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < phone_book.length; i++) {
            set.add(phone_book[i]);
        }

        // 2. set에 키 값을 포함하는 값이 있는지 확인
        for (String key: set){
            for (int i = 0; i < key.length(); i++) {
                if (set.contains(key.substring(0, i))){
                    answer = false;
                    break;
                }
            }
        }
        
        return answer;
    }
}