import java.util.*;

class Solution {
    String[][] tickets;
    boolean[] visited;
    String[] answer;
    
    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });

        this.visited = new boolean[tickets.length];
        this.answer = new String[tickets.length + 1];

        answer[0] ="ICN";

         dfs("ICN", 0);
        
        return answer;
    }
    
    
    public boolean dfs(String node, int depth) {
        if (depth == tickets.length) {
            return true;
        }

        for (int i = 0; i < tickets.length; i++) {
            String start = tickets[i][0];
            String next = tickets[i][1];

            if (start.equals(node) && !visited[i]) {
                visited[i] = true;
                answer[depth+1] = next;
                if (dfs(next, depth + 1)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
}