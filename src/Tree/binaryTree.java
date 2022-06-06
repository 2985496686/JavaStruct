package Tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class binaryTree {
    treeNode root;
    public binaryTree(){
    }
    public binaryTree(treeNode root){
        this.root = root;
    }
    //前序遍历
    private void prevOrder(treeNode Node){
        if(Node == null) return;
        Node.display();
        prevOrder(Node.left);
        prevOrder(Node.right);
    }
    public void prevOrder(){
        prevOrder(root);
        System.out.println();
    }
    //前序遍历非递归
    public void prevOrderByStack(){
        if(root == null) return;
        Stack<treeNode> stack = new Stack<>();
        treeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                cur.display();
                stack.push(cur);
                cur = cur.left;
            }
            if(!stack.isEmpty()){
                cur = stack.pop();
                cur = cur.right;
            }
        }
        System.out.println();
    }

    //中序遍历
    private void inOrder(treeNode Node){
        if(Node == null) return;
        inOrder(Node.left);
        Node.display();
        inOrder(Node.right);
    }
    public void inOrder(){
        inOrder(root);
        System.out.println();
    }

    //中序遍历非递归
    public void inOrderByStack(){
        Stack<treeNode> stack = new Stack<>();
        treeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            if(!stack.isEmpty()){
                cur = stack.pop();
                cur.display();
                cur = cur.right;
            }
        }
        System.out.println();
    }

    //后序遍历
    private void postOrder(treeNode Node){
        if(Node == null) return;
        postOrder(Node.left);
        postOrder(Node.right);
        Node.display();
    }
    public void postOrder(){
        postOrder(root);
        System.out.println();
    }

    //后序遍历非递归
    public void postOrderByStack(){
        treeNode cur = root;
        treeNode prev = null;
        Stack<treeNode> stack = new Stack<>();
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            if(!stack.isEmpty()){
                cur = stack.peek().right;
                if(cur == null || prev == cur){
                    cur = stack.pop();
                    cur.display();
                    prev = cur;
                    cur = null;
                }
            }
        }
    }

    //层序遍历
    public void levelOrder(){
        Queue<treeNode> queue = new ArrayDeque<>();
        if(root != null){
            queue.offer(root);
        }
        while(queue.peek() != null){
            treeNode cur = queue.poll();
            System.out.print(cur.value + " ");
            if(cur.left != null){
                queue.offer(cur.left);
            }
            if(cur.right != null){
                queue.offer(cur.right);
            }
        }
    }
}
class test{
    public static void main(String[] args) {
        treeNode A = new treeNode("A");
        treeNode B = new treeNode("B");
        treeNode C = new treeNode("C");
        treeNode D = new treeNode("D");
        treeNode E = new treeNode("E");
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        binaryTree tree = new binaryTree(A);
        tree.levelOrder();
    }
}
