package Algorithm.LeetCode;

import java.util.ArrayDeque;
import java.util.Queue;

public class leetcode__513 {
    /*深度优先搜索
class Solution {
    int arr[][];
    public Solution(){
        arr = new int[1][2];
    }
    public  void getMaxLeft(TreeNode root,int high){
        if(high > arr[0][0]){
            arr[0][1] = root.val;
            arr[0][0] = high;
        }
        if(root.left != null){
            getMaxLeft(root.left,high+1);
        }
        if(root.right != null){
            getMaxLeft(root.right,high+1);
        }
    }
    public int findBottomLeftValue(TreeNode root) {
        arr[0][0] = 1;
        arr[0][1] = root.val;
        getMaxLeft(root,1);
        return arr[0][1];
    }
}*/
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        TreeNode curNode = root;
        if(root != null){
            queue.offer(root);
        }
        while(!queue.isEmpty()){
            curNode = queue.poll();
            if(curNode.right != null){
                queue.offer(curNode.right);
            }
            if(curNode.left != null){
                queue.offer(curNode.left);
            }
        }
        return curNode.val;

    }

}
