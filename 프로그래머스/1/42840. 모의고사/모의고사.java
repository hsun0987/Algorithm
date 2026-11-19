import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] s1 = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        int[] s2 = {2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5};
        int[] s3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] cnt = new int[3];        
        
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == s1[i % s1.length]) cnt[0]++;
            
            if(answers[i] == s2[i % s2.length]) cnt[1]++;
            
            if(answers[i] == s3[i % s3.length]) cnt[2]++;
        }
        
        int max = 0;
        for(int c : cnt) {
            max = Math.max(max, c);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < 3; i++) {
            if(max == cnt[i])
                list.add(i+1);
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        } 
        
        
        return answer;
    }
}