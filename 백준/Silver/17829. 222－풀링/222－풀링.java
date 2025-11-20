import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = quadTree(N, 0, 0);

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }

    static int quadTree(int n, int y, int x){
        if (n == 1){
            return graph[y][x];
        }

        int halfN = n / 2;

        int topLeft = quadTree(halfN, y, x);
        int topRight = quadTree(halfN, y, x+halfN);
        int bottomLeft = quadTree(halfN, y+halfN, x);
        int bottomRight = quadTree(halfN, y+halfN, x+halfN);

        int[] values = {topLeft, topRight, bottomLeft, bottomRight};
        Arrays.sort(values);
        // 오름차순 정렬 -> 2번째로 큰 수는 3번째 수
        return values[2];
    }
}