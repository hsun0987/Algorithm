import java.util.*;

class Solution {
    String begin;
    String target; 
    String[] words;
    boolean[] visited;
    
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        this.begin = begin;
        this.target = target;
        this.words = words;
        this.visited = new boolean[words.length];
        
        answer = bfs();
        
        return answer;
    }
    
    class Node {
        String word;
        int depth;

        Node(String word, int depth) {
            this.word = word;
            this.depth = depth;
        }
    }
    
    public int bfs() {
        Queue<Node> q = new LinkedList<>();

        // begin 이랑 1개만 다른 단어 큐에 넣기
        for (int i = 0; i < words.length; i++) {
            if(compareWord(begin, words[i]) == 1) {
                visited[i] = true;
                q.add(new Node(words[i], 1));
            }
        }

        while (!q.isEmpty()) {
            Node current = q.poll();
            String word = current.word;
            int depth = current.depth;
            
            if (word.equals(target)) {
                return depth;
            }

            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && compareWord(word, words[i]) == 1) {
                    // 현재 단어가 target 이면 반황
                    if (words[i].equals(target)) {
                        return depth + 1;
                    }
                    visited[i] = true;
                    q.add(new Node(words[i], depth + 1));
                }
            }

        }

        return 0;

    }

    public int compareWord(String w1, String w2) {
        int cnt = 0;
        for (int i = 0; i < begin.length(); i++){
            if (w1.charAt(i) == w2.charAt(i)) {
                cnt++;
            }
        }

        if (cnt == begin.length() - 1) {
            return 1;
        }

        return -1;
    }

}