class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = {};
        
        for (int[] query : queries) {
            int first = query[0];
            int second = query[1];
            
            int temp = 0;
            temp = arr[first];
            arr[first] = arr[second];
            arr[second] = temp;
        }
        
        answer = arr;
        return answer;
    }
    
}