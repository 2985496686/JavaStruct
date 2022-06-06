package Algorithm.Assessment;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class MyBinaryTree {
    class Node{
        int val;
        Node leftNode;
        Node rightNode;
        public Node(){};
        public Node(int val){
            this.val = val;
        }
    }
    Node root;
    /*
    public void binaryTreeGreat(){
        int val;
        Scanner scanner = new Scanner(System.in);
        val = scanner.nextInt();
        root = new Node(val);
        binaryTreeGreat(root);
    }
    public boolean binaryTreeGreat(Node node){
        int val;
        Scanner scanner = new Scanner(System.in);
        val = scanner.nextInt();
        if(val == )
    }*/

    //层序遍历
    public void levelOrder(){
        Deque<Node> queue = new ArrayDeque<>();
        if(root != null){
            queue.offer(root);
        }
        while(queue.peek() != null){
            Node cur = queue.poll();
            System.out.print(cur.val + " ");
            if(cur.leftNode != null){
                queue.offer(cur.leftNode);
            }
            if(cur.rightNode != null){
                queue.offer(cur.rightNode);
            }
        }
    }

    public static void main(String[] args) {
        MyBinaryTree m = new MyBinaryTree();
       // m.binaryTreeGreat();
        m.levelOrder();
    }
}
