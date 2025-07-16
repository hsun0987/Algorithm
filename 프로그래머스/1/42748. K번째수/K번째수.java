import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        int k = 0;
        for(int[] a : commands){
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = a[0]-1; i < a[1]; i++){
                list.add(array[i]);
            }
            Collections.sort(list);
            answer[k++] = list.get(a[2]-1);
        }
        return answer;
    }
}