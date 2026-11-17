import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
            
        HashSet<Integer> set = new HashSet<>();
        for(int wn : win_nums) {
            set.add(wn);
        }
            
        int zero = 0;
        int minNum = 0;
        for(int i = 0; i < lottos.length; i++) {
            if(lottos[i] == 0) {
                zero++;
                continue;
            }
            
            if(set.contains(lottos[i])) {
                minNum++;
            }
        }
        
        int maxNum = minNum + zero;
        
        answer[0] = function(maxNum);
        answer[1] = function(minNum);
        
        
        return answer;
    }
    
    int function(int num) {
        switch(num) {
            case 6: // 6개 일치
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
        
    }
}