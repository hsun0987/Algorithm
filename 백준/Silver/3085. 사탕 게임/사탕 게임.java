import java.io.*;

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static char[][] graph;
    static int N;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        graph = new char[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            graph[i] = input.toCharArray();
        }

        answer = 0;
        bruteforce();

        bw.write(answer +"");
        bw.flush();
        bw.close();
    }
    static void bruteforce(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 상하좌우 자리 바꾸기
                for (int k = 0; k < 4; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];

                    if (x >= 0 && x < N && y >= 0 && y < N && graph[i][j] != graph[x][y]){
                        // 1. 사탕 위치 교환
                        char temp = graph[i][j];
                        graph[i][j] = graph[x][y];
                        graph[x][y] = temp;

                        // 2. 전체 가장 긴 연속 부분 갯수 구하기
                        answer = Math.max(maxCandies(), answer);

                        // 3. 원래대로 위치 되돌리기
                        temp = graph[i][j];
                        graph[i][j] = graph[x][y];
                        graph[x][y] = temp;
                    }
                }
            }
        }
    }

    static int maxCandies(){
        int max = 0;

        // 모든 행 가장 긴 구간
        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = 1; j < N; j++) {
                if (graph[i][j] == graph[i][j-1]){
                    cnt++;
                }else{
                    max = Math.max(max, cnt);
                    cnt = 1; // 리셋
                }
            }
            max = Math.max(max, cnt);
        }


        // 모든 열 가장 긴 구간
        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = 1; j < N; j++) {
                if (graph[j][i] == graph[j-1][i]) {
                    cnt++;
                }else{
                    max = Math.max(max, cnt);
                    cnt = 1; // 리셋
                }
            }
            max = Math.max(max, cnt);
        }

        return max;
    }
}