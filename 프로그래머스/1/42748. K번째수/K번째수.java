import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        // commands 만큼 반복
        // i~j 까지 자른 배열 만들기
        // 정렬
        // k번째 수 answer 저장

        for (int i = 0; i < commands.length; i++) {
            int a = commands[i][0] - 1; // 인덱스 = a-1
            int b = commands[i][1];
            int k = commands[i][2];

            ArrayList<Integer> list = new ArrayList<>();
            for (int j = a; j < b; j++) {
                list.add(array[j]);
            }

            Collections.sort(list);
            answer[i] = list.get(k-1);
        }

        return answer;
    }
}