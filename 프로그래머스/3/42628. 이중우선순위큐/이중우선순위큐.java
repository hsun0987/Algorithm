import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer;
// 1. 트리맵 이용 -> 이진트리 기반 Map 컬렉션
        // 키 기준 자동 오름차순 정렬
        // (삽입한 값, 개수)
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        for(String s : operations){
            String[] now = s.split(" ");
            int num = Integer.parseInt(now[1]);
            // 2. I: 삽입, D1: 최댓값 삭제, D-1: 최솟값 삭제
            switch (now[0]){
                case "I":
                    // 숫자 삽입(이미 있을 경우 개수 +1)
                    treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
                    break;

                case "D":
                    if (treeMap.isEmpty()){
                        continue;
                    }
                    
                    int key;
                    if (num == 1){
                        // 최댓값(마지막)
                        key = treeMap.lastKey();
                    }else{
                        // 최솟값(첫번째)
                        key = treeMap.firstKey();
                    }

                    if (treeMap.get(key) > 1){
                        // 중복값이 있을 경우
                        treeMap.put(key, treeMap.get(key) - 1);
                    }else{
                        treeMap.remove(key);
                    }
            }
        }

        // 3. 맵이 비어있으면 [0,0], 아니면 [최대, 최소]
        if (treeMap.isEmpty()){
            answer = new int[]{0, 0};
        }else{
            answer = new int[]{treeMap.lastKey(), treeMap.firstKey()};
        }

        return answer;
    }
}