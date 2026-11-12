import java.util.*;

class Solution {
    public int solution(String s) {
        int len = s.length();
        int answer = len;
        
        for(int i = 1; i < len; i++) {    
            ArrayList<String> list = new ArrayList<>();
            
            for(int k = 0; i*k < len; k++) {
                list.add(s.substring(i*k, Math.min(i*k + i, len)));
            }
            
            // 다음 문자열이랑 비교
            StringBuilder sb = new StringBuilder();
            int cnt = 1;
            for(int k = 1; k < list.size(); k++) {
                if( list.get(k-1).equals(list.get(k))) {
                    cnt++;
                } else {
                    if(cnt > 1) {
                        sb.append("" + cnt);
                    }
                    sb.append(list.get(k-1));
                    cnt = 1;
                }
            }
            
            // 마지막 문자열 처리
            if (cnt > 1) {
                sb.append(cnt);
            }
            sb.append(list.get(list.size()-1));
            
            // 현재 answer 최솟값 갱신
            answer = Math.min(answer, sb.length());
            
        }
        
        return answer;
    }
}