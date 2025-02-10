import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        
        // 1. 카드 삭제가 편하게 큐에 넣기
        Queue<String> c1 = new LinkedList<>();
        Queue<String> c2 = new LinkedList<>();
        
        for (String c: cards1){
            c1.add(c);
        }
        for (String c: cards2){
            c2.add(c);
        }
        
        // 2. top에 goal에 원하는 단어가 있다면 빼서 사용(제거)
        for (int i = 0; i < goal.length; i++) {
            if (!c1.isEmpty() && c1.peek().equals(goal[i])){
                c1.poll();
            } else if (!c2.isEmpty() && c2.peek().equals(goal[i])) {
                c2.poll();
            }else{
                // 3. 두 카드 뭉치 내에 원하는 단어가 없다면 no, break
                answer = "No";
                break;
            }
        }
        
        return answer;
    }
}