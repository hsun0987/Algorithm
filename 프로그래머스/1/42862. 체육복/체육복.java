class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        // 초기 체육복 1씩 가지고 있는 배열 생성
        int[] student = new int[n];
        for (int i = 0; i < n; i++) {
            student[i] = 1;
        }

        // 분실
        for (int i : lost) {
            student[i-1] -= 1;
        }

        // 여벌 옷
        for (int i : reserve) {
            student[i-1] += 1;
        }

        for (int i = 0; i < n; i++) {
            // 1. 여벌 옷 있는 사람 찾기
            if (student[i] == 2) {
                // 왼쪽 학생 0인지 확인
                if (i > 0 && student[i-1] == 0) {
                    student[i-1] = 1;
                    student[i] = 1;
                } else if (i < n-1 && student[i+1] == 0) {
                    student[i] = 1;
                    student[i+1] = 1;
                }
            }
        }

        for (int s : student) {
            if (s > 0) {
                answer++;
            }
        }
        
        return answer;
    }
}