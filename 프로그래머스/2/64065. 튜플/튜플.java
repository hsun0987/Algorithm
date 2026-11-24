import java.util.*;

class Solution {
    public int[] solution(String s) {
    
        s = s.replace(",{", "");
        s = s.replace("{{", "");
        String[] s1 = s.split("}");
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();  
        
       for(String ss : s1) {
           String[] now = ss.split(",");
    
            ArrayList<Integer> arr = new ArrayList<>();
            for(String n : now) {
                arr.add(Integer.valueOf(n));
            } 
            list.add(arr);
       }
       
        Collections.sort(list, (a, b) -> Integer.compare(a.size(), b.size()));
        
        ArrayList<Integer> temp = new ArrayList<>();
        
        for(ArrayList<Integer> a : list) {
            for(int i : a) {
                if(!temp.contains(i)) {
                    temp.add(i);
                }
            }
        }
        
        int[] answer = temp.stream().mapToInt(Integer::intValue).toArray();
        
        
        return answer;
    }
}