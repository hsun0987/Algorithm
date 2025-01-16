import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        // 1. 1초 당 트럭 1, 다리 1씩 지남
        // - 최대 무게 이하, 다리의 길이 만큼 1초에 1번씩 큐에 추가(다리를 건너는 트럭)
        // 2. 이동할 때마다 시간(answer) 누적

        // 다리를 건너는 트럭 큐 생성
        Queue<Integer> trucks = new LinkedList<>();
        int current = 0;
        for (int i = 0; i < truck_weights.length; i++) {
            int truck = truck_weights[i];

            // 트럭 추가, 제거를 동시에 연속적으로 반복
            while (true){
                // 다리에 트럭이 비었을 때 -> 트럭을 다리에 올림
                if (trucks.isEmpty()) {
                    trucks.add(truck);
                    current += truck;
                    answer++;
                    break;
                }
                // 다리에 트럭이 꽉 찼을 때 -> 트럭을 하나 제거
                else if (trucks.size() == bridge_length){
                    current -= trucks.remove();
                }
                // 다리에 자리가 남았을 때
                else{
                    // 무게를 비교하며 이동 가능한 트럭 추가
                    answer++;
                    if (weight >= current + truck){
                        trucks.add(truck);
                        current += truck;
                        break;
                    }else{
                        // 무게를 초과하면 0으로 자리를 채움
                        trucks.add(0);
                    }
                }
            }
        }
        
        // 마지막 남은 트럭
        answer += bridge_length;

        return answer;
    }
}