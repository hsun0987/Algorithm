import java.util.*;

class Solution {   
    int n;
    int[][] wires;
    boolean[] visited;
    boolean[][] graph;

    int solution(int n, int[][] wires) {
        this.n = n;
        this.wires = wires;
        int answer = n;
        int len = wires.length;

        int idx = 0; // 1개씩 끊어낼 간선
        for (int i = 0; i < len; i++) {
            // 그래프 만들기 (1~N)
            graph = new boolean[n+1][n+1];
            for (int j = 0; j < len; j++) {
                if (idx == j) {
                    continue;
                }
                int[] current = wires[j];
                graph[current[0]][current[1]] = true;
                graph[current[1]][current[0]] = true;
            }
            // 방문안한 송전탑이 있으면 dfs 돌기
            // A랑 B 구간의 갯수를 따로 구한 후 차를 구해야함
            visited = new boolean[n+1];
            int[] AB = wires[idx]; // 끊은 간선 (이 A, B 구간 구하기)
            int A = dfs(AB[0]);
            int B =  dfs(AB[1]);

            answer = Math.min(Math.abs(A-B), answer);
            idx++;
        }


        return answer;
    }

    int dfs (int start) {
        visited[start] = true;
        
        int cnt = 1; // 자기자신

        for (int i = 1; i < n+1; i++) {
            if (!visited[i] && graph[start][i]) {
                // 방문한 노드의 총 개수 합
                cnt += dfs(i);
            }
        }

        return cnt;
    }
}

