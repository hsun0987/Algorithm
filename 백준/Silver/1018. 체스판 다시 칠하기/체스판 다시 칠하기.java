import java.io.*;

public class Main {
    public static int getSolution(int startRow, int startCol, String[] arr){
        String[] board = {"WBWBWBWB", "BWBWBWBW"}; // 화이트로 시작하는 고정 배열

        // 화이트를 기준으로 최소 비용 계산
        int whiteCount = 0;
        for (int i = 0; i < 8; i++) {
            int row = startRow + i;
            for (int j = 0; j < 8; j++) {
                int col = startCol + j;
                if (arr[row].charAt(col) != board[row % 2].charAt(j)){
                    whiteCount++;
                }
            }
        }
        // blackCount(블랙버전 체스판 최소 비용) = 64(8*8) - whiteCount
        return Math.min(whiteCount, 64 - whiteCount);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // ** 최소 칠해야하는 Count
        // 현재상태, B 체스판 최소비용, W 체스판 최소비용 비교

        // 1. NxM 배열 생성
        // - 크기는 8x8 최소로 크기를 잘라야함
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        //2. 체스판 자르기
        int min = Integer.MAX_VALUE;
        // n-8 = 8x8로 만들어주기 위한 최소범위
        // ex) if n = 10, i = 10-8 = 2
        // -> (0,0) / (1,0) / (2,0) 부터 시작하는 범위 탐색
        for (int i = 0; i <= n-8; i++) {
            for (int j = 0; j <= m-8; j++) {
                // 3. 현재 체스판의 최소 비용
                int curMin = getSolution(i, j, arr);
                // 4. 전체 최소 값 비교 후 갱신
                if (min > curMin)
                    min = curMin;
            }
        }

        bw.write(min + "");
        bw.flush();
        bw.close();
    }
}