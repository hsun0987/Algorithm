import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        //1. 산술평균
        int avg = (int) (Math.round(Arrays.stream(arr).average().orElse(0)) / 1.0);
        bw.write(avg + "\n");

        //2. 중앙값
        int mid = arr[n/2];
        bw.write(mid + "\n");

        //3. 최빈값
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        // 최댓값 저장
        int max = Collections.max(map.values());

        // 최댓값과 같은 빈도수를 가진 키 저장
        ArrayList<Integer> list = new ArrayList<>();
        for (int key: map.keySet()){
            if (max == map.get(key)){
                list.add(key);
            }
        }
        Collections.sort(list);

        // 최빈값이 여러값일 경우 두번째로 작은 값
        if (list.size() > 1){
            bw.write(list.get(1) + "\n");
        }else{
            bw.write(list.get(0) + "\n");
        }

        //4. 범위
        int range = arr[n-1] - arr[0];
        bw.write(range + "");

        bw.flush();
        bw.close();
    }
}