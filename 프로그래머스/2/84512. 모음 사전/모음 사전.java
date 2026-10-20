class Solution {
    String word;
    char[] arr = {'A', 'E', 'I', 'O', 'U'};
    int answer;
    boolean found;
    
    public int solution(String word) {
        answer = 0;
        found = false;

        this.word = word;
        dfs(0, "");

        return answer;
    }
    
    void dfs(int depth, String w) {
        if (w.equals(word)) {
            found = true;
            return;
        }

        if (w.length() == 5) {
            return;
        }

        for (char a : arr) {
            if (found) { // word 를 찾으면 재귀 반복 X
                break;
            }
            answer++;
            dfs(depth+1, w+a);
        }
    }
}