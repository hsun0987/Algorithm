class Solution {
    public long solution(String numbers) {
        long answer = 0;
        
        // 1. 영어를 String 배열에 저장
        // 2. numbers에서 찾아서 숫자로 바꾸기 -> replaceAll

        String[] str = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < str.length; i++) {
            numbers = numbers.replaceAll(str[i], String.valueOf(i));
        }
        
        answer = Long.parseLong(numbers);
        
        return answer;
    }
}