import java.util.*;
class Solution {
    int answer;
    int n;
    boolean[] visited;
    boolean[][] graph;

    public int solution(int n, int[][] wires) {
        this.n = n;
        answer = Integer.MAX_VALUE;
        visited = new boolean[n+1];
        graph = new boolean[n+1][n+1];

        for(int[] w : wires) {
            graph[w[0]][w[1]] = true;
            graph[w[1]][w[0]] = true;
        }

        dfs(1, 0);

        return answer;
    }

    // 현재노드, 부모 노드
    int dfs(int A, int B) {
        int cnt = 1;
        // 현재 A구간의 자식 노드 개수 구하기
        for(int i = 1; i < n+1; i++) {
            // 부모 노드는 탐색 x
            if(i != B && graph[A][i]) {
                cnt += dfs(i, A);
            }
        }

        // A - B 차이 구하기, 최솟값 갱신
        if(B != 0) {
            int diff = Math.abs(cnt - (n - cnt));
            answer = Math.min(diff, answer);
        }

        return cnt;
    }
}

