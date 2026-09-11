class Solution {
    int answer = 0;
    int cnt = 0;
    String[] alphabet = {"A", "E", "I", "O", "U"};
    public int solution(String word) {
        
        dfs("", word);
        
        return answer;
    }
    
    public void dfs (String current, String word) {
        if (current.length() >= 5) {
            return;
        }

        for (String i : alphabet) {
            cnt++;
            String next = current + i;
            if (next.equals(word)) {
                answer = cnt;
                break;
            }
            dfs(next, word);
        }
    }
}