import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, ArrayList<int[]>> mapGenres = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            // 고유번호, 재생횟수
            if (!mapGenres.containsKey(genres[i])) {
                mapGenres.put(genres[i], new ArrayList<>());
            }
            mapGenres.get(genres[i]).add(new int[]{i, plays[i]});
        }

        HashMap<String, Integer> totalGenre = new HashMap<>();
        // 장르별 합계 구하기
        for (String key : mapGenres.keySet()) {
            int sum = 0;
            for (int[] m : mapGenres.get(key)) {
                sum += m[1];
            }
            totalGenre.put(key, sum);
        }

        // 장르별 합계가 많은 순으로 정렬
        List<String> totalKeySet = new ArrayList<>(totalGenre.keySet());
        // value 값으로 내림차순 정렬
        totalKeySet.sort((o1, o2) -> totalGenre.get(o2).compareTo(totalGenre.get(o1)));

        ArrayList<Integer> temp = new ArrayList<>();
        // 장르 별로 가장 많이 재생된 2곡 수록
        for (String key : totalKeySet) {
            // 장르 리스트
            ArrayList<int[]> current = mapGenres.get(key);

            // 1곡만 있는 경우
            if (current.size() < 2) {
                temp.add(mapGenres.get(key).get(0)[0]);
                continue;
            }

            // 장르 리스트 내림차순 정렬
            Collections.sort(current, (a, b) -> b[1] - a[1]);

            for (int i = 0; i < 2; i++) {
                temp.add(mapGenres.get(key).get(i)[0]);
            }
        }

        // answer에 넣기
        int[] answer = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            answer[i] = temp.get(i);
        }

        return answer;
    }
}