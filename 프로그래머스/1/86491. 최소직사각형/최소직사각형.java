class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        // 1. 둘 중 더 긴 것을 가로, 짧은 것을 세로
        // 2. 가로 중 max, 세로 중 max
        // 3. 가로 * 세로

        int width = 1;
        int height = 1;

        for (int[] size : sizes){
            if (size[0] >= size[1]){
                width = Math.max(width, size[0]);
                height = Math.max(height, size[1]);
            }else{
                width = Math.max(width, size[1]);
                height = Math.max(height, size[0]);
            }
        }
        
        answer = width * height;
        
        return answer;
    }
}