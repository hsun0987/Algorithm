import java.util.*;

class Solution {
    public static int[] solution(int[] arr) {
        int[] answer = {};

        ArrayList<Integer> list = new ArrayList<>();
        for (int i : arr){
            list.add(i);
        }

        if (list.size() <= 1){
            return new int[]{-1};
        }

        // 1. 최솟값 찾기 - 값이 1개면 -1 반환 (인덱스 저장)
        int min = Collections.min(list);

        for (int i = 0; i < list.size(); i++) {
            // 2. 최솟값 제거
            if (list.get(i) == min){
                list.remove(i);
            }
        }

        // 3. 반환
        answer = list.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}