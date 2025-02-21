import java.util.*;

class Solution {
    static HashSet<Integer> set;
    static boolean[] visited = new boolean[7]; // 1~7자리 숫자

    public static int solution(String numbers) {
        int answer = 0;

        // 1. 숫자의 각 조합을 만든다
        // - 중복을 자동 제거하는 hash set에 저장
        // - 문자열을 붙이고 int로 변환
        // 2. 소수인지 확인
        // 3. 소수면 카운드 + 1

        set = new HashSet<>();
        // 재귀 사용
        dfs(numbers, "", 0);

        for (int n : set){
            if (isPrime(n)){
                answer++;
            }
        }

        return answer;
    }

    public static void dfs(String numbers, String s, int depth) {
        if (depth > numbers.length()){
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]){
                visited[i] = true;
                // 현재 문자에 1개씩 붙여서 추가
                set.add(Integer.parseInt(s + numbers.charAt(i)));
                dfs(numbers, s + numbers.charAt(i), depth + 1);
                visited[i] = false;
            }
        }
    }

    public static boolean isPrime(int n){
        if (n < 2){
            return false;
        }
        for (int i = 2; i <= Math.sqrt((n)) ; i++) {
            if (n % i == 0){
                return false;
            }
        }

        return true;
    }
}