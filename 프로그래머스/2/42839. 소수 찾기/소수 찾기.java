import java.util.*;
class Solution {
    String numbers;
    boolean[] visited;
    Set<Integer> set; // 소수 모음 -> 중복제거
    
    public int solution(String numbers) {
        this.numbers = numbers;
        int answer = 0;

        visited = new boolean[numbers.length()];
        set = new HashSet<>();
        dfs(0, "");
        
        answer = set.size(); 

        return answer;
    }

    void dfs(int depth, String temp) {
        // 소수 인지 확인
        if (isPrimeNum(temp)) {
            // 011 = 11 이기 때문에 Integer 로 변환 
            set.add(Integer.parseInt(temp));
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth+1, temp + numbers.charAt(i));
                visited[i] = false;
            }
        }
    }

    boolean isPrimeNum(String temp) {
        if (temp.isEmpty()) {
            return false;
        }

        int n = Integer.parseInt(temp);
        if (n < 2) {
            return false;
        }
        
        for (int i = 2; i <= Math.sqrt(n) ; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}