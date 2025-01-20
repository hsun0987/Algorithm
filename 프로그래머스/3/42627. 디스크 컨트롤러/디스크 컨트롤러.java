import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        // 0. jobs 요청시간 순 정렬
        Arrays.sort(jobs, (o1,o2) -> o1[0]-o2[0]);

        // 1. 우선순위 큐에 삽입
        // - 1) 소요시간 2) 요청시간
        // 소요 시간 기준 오름차순
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);

        // 2. 평균 = (작업종료 시간 - 요청시간)의 합 / 개수
        int time = 0;
        int sum = 0;
        int idx = 0;
        int len = jobs.length;
        while(!pq.isEmpty() || idx < len){
            // 현재 시간 보다 작거나 같은 요청시간을 큐에 추가
            while (idx < len && jobs[idx][0] <= time){
                pq.offer(jobs[idx++]);
            }

            // 큐가 비어있으면 가장 가까운 요청시간으로 이동
            if (pq.isEmpty()){
                time = jobs[idx][0];
            }

            // 큐에 작업이 있으면 소요시간이 빠른 작업 수행
            else{
                int[] now = pq.poll();
                // 1. 작업종료 시간 = 누적시간(지금 + 소요)
                time += now[1];
                // 2. 반환 시간 계산 후 누적
                sum += time - now[0];
            }

        }

        // 3. 평균
        answer = sum / len;
        
        return answer;
    }
}