import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        // 1. 배열 자르기
        int j = 0;
        for (int[] a: commands){
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = a[0]-1; i < a[1]; i++) {
                list.add(array[i]);
            }
            // 2. 정렬
            Collections.sort(list);
            // 3. k번째 수 구하기
            answer[j++] = list.get(a[2]-1);
        }
        
        return answer;
    }
}