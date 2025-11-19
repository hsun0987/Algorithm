import java.io.*;
import java.util.*;

public class Main {
    static char[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        graph = new char[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            graph[i] = input.toCharArray();
        }

        String answer = quad_tree(N, 0, 0);

        bw.write(answer +"");
        bw.flush();
        bw.close();
    }

    static String quad_tree(int n, int y, int x){
        for (int i = y; i < y+n; i++) {
            for (int j = x; j < x+n; j++) {
                if (graph[y][x] != graph[i][j]){
                    int halfN = n / 2;
                    StringBuilder sb = new StringBuilder();
                    sb.append("(");
                    sb.append(quad_tree(halfN, y, x));
                    sb.append(quad_tree(halfN, y, x + halfN));
                    sb.append(quad_tree(halfN, y + halfN, x));
                    sb.append(quad_tree(halfN, y + halfN, x + halfN));
                    sb.append(")");

                    return sb.toString();
                }
            }
        }
        return String.valueOf(graph[y][x]);
    }
}