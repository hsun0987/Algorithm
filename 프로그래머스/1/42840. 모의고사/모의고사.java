import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        // 1. 한명씩 모든 답 채점
        // 1-1. 3명의 답을 각각 배열에 저장
        int[] a1 = new int[]{1, 2, 3, 4, 5};
        int[] a2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] a3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] cnt = new int[3];

        // 1-2. 각 답과 정답을 비교 후 count
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == a1[i % a1.length]){
                cnt[0]++;
            }
            if (answers[i] == a2[i % a2.length]){
                cnt[1]++;
            }
            if (answers[i] == a3[i % a3.length]){
                cnt[2]++;
            }
        }

        // 2. 채점 결과가 가장 큰 학생 answer
        int max = Arrays.stream(cnt).max().getAsInt();
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == max){
                answer.add(i+1);
            }
        }
        
        return answer;
    }
}