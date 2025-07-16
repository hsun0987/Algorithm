import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        // 년.월.일 = 일수로 바꿔서 비교 !!
        
        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] split = term.split(" ");
            termMap.put(split[0], Integer.parseInt(split[1]));
        }

        String[] todaySplit = today.split("\\.");
        int todayTotal = dateToDays(todaySplit[0], todaySplit[1], todaySplit[2]);

        List<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] split = privacies[i].split(" ");
            String[] dateSplit = split[0].split("\\.");
            int period = termMap.get(split[1]);
            int privacyTotal = dateToDays(dateSplit[0], dateSplit[1], dateSplit[2]) + period * 28 - 1;

            if (privacyTotal < todayTotal) {
                answerList.add(i + 1); // 1-based index
            }
        }

        // 결과 배열로 변환
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }

    private int dateToDays(String y, String m, String d) {
        int year = Integer.parseInt(y);
        int month = Integer.parseInt(m);
        int day = Integer.parseInt(d);
        return (year * 12 * 28) + (month * 28) + day;
    }
}
