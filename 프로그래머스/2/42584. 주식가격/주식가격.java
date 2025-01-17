import java.util.*;

class Solution {
    public Stack<Integer> solution(int[] prices) {
       Stack<Integer> answer = new Stack<>();
        // 현재 주식 가격보다 작은 가격이 나올 때 -> 떨어진 기간
        for (int i = 0; i < prices.length; i++) {
            int count = 0;
            for (int j = i+1; j < prices.length; j++) {
                count++;
                // 가격이 떨어질 때 빠져나옴 > 시간 초과 방지
                if (prices[i] > prices[j]){
                    break;
                }
            }
            answer.add(count);
        }
        return answer;
    }
}