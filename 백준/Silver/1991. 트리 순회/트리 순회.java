import java.io.*;
import java.util.*;

public class Main {
    static Node head = new Node('A', null, null);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            // head 노드를 기준으로 입력받은 노드를 붙임
            addNode(head, root, left, right);
        }

        preOrder(head);
        System.out.println();
        inOrder(head);
        System.out.println();
        postOrder(head);
    }
    static class Node{
        char value;
        Node left;
        Node right;

        public Node(char value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    public static void addNode(Node target, char root, char left, char right){
        // root인 경우(가장 첫번째 노드) -> root의 왼쪽과 오른쪽 노드 값을 넣어줌
        if(target.value == root){
            target.left = (left == '.' ? null : new Node(left, null, null));
            target.right = (right == '.' ? null : new Node(right, null, null));
        }
        else {
            // 하위노드가 있는지 확인 후 추가
            if(target.left != null) addNode(target.left, root, left, right);
            if(target.right != null) addNode(target.right, root, left, right);
        }
    }

    // 전위 순회 VLR
    public static void preOrder(Node node){
        if(node == null) return;
        System.out.print(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }
    // 중위 순회 LVR
    public static void inOrder(Node node){
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.value);
        inOrder(node.right);
    }
    // 후위 순회 LRV
    public static void postOrder(Node node){
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value);
    }
}