import java.io.*;
import java.util.*;

public class Main {
    static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        // A[N] 정렬
        Arrays.sort(a);

        for (int i = 0; i < m; i++) {
            if(binarySearch(b[i]) == 1){
                bw.write("1 \n");
            }else{
                bw.write("0 \n");
            }
        }
        bw.flush();
        bw.close();
    }

    // 이진 탐색 트리 이용
    static int binarySearch(int key){
        int mid;
        int low = 0;
        int high = a.length -1;

        while(low <= high){
            mid = (low + high) /2;

            if(key == a[mid]){
                return 1;
            } else if (key < a[mid]) {  // mid 앞부분 탐색
                high = mid - 1 ;
            } else{ // mid 뒷부분 탐색
                low = mid + 1;
            }
        }
        return 0;
    }
}