import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        // 최소힙 -> 우선순위 큐 이용
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            heap.add(scoville[i]);
        }
        
        while(!heap.isEmpty()){
            // 최솟값이 K보다 크거나 같아지면 끝
            if (heap.peek() >= K){
                break;
            }else if (heap.size() == 1){
                // 힙의 크기가 1이고 K이상 만들 수 없는 경우 
                answer = -1;
                break;
            }else{
                // 스코빌 지수 = 최솟값 + (두번째 최솟값 * 2)
                // 힙에서 최솟값 2개로 계산 후 다시 push
                int a = heap.poll();
                int b = heap.poll();
                heap.add(a + (b*2));
                answer++;
            }
        }
        return answer;
    }
}