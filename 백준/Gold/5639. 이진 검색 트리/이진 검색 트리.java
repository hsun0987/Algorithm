import java.io.*;

public class Main {
    static Node tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 이진 검색 트리(L < V < R)
        // 1. 전위 순회로 트리 만들기
        // V를 기준으로 작으면 왼쪽, 크면 오른쪽 >> 재귀 이용
        // 2. 후위 순회로 트리 출력

        // 가장 처음 입력 값이 최상위 root
        tree = new Node(Integer.parseInt(br.readLine()), null, null);

        while (true){
            String input = br.readLine();
            if (input == null || input.isEmpty()){
                break;
            }
            int node = Integer.parseInt(input);
            addNode(tree, node);
        }
        postOrder(tree);
    }

    static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    static void addNode(Node tree, int x){
        // L < V
        if (tree.value > x){
            if(tree.left == null){
                tree.left = new Node(x, null, null);
            }else{
                addNode(tree.left, x);
            }
        }
        // V < R
        else{
            if(tree.right == null){
                tree.right = new Node(x, null, null);
            }else{
                addNode(tree.right, x);
            }
        }
    }
    // 후위 순회 LRV
    public static void postOrder(Node node){
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }
}