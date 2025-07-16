import java.util.*;

class Solution {
    static int[] temp;
    static Set<Integer> set;
    static int[] ns;
    
    public int[] solution(int[] numbers) {
        
        Arrays.sort(numbers);
        set = new LinkedHashSet<>();// 중복제거
        temp = new int[2];
        ns = numbers;
        dfs(0, 0);    
        
        int[] answer = set.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(answer);
        
        return answer;
    }
    
    static void dfs(int depth, int start){
        if(depth == 2){
            set.add(temp[0] + temp[1]);
            return;
        }
        
        for(int i = start; i < ns.length; i++){
            temp[depth] = ns[i];
            dfs(depth + 1, i + 1);
        }
    }
}