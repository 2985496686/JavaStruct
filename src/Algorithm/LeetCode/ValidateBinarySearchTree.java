package Algorithm.LeetCode;

import java.util.ArrayList;

//力扣：98
public class ValidateBinarySearchTree {

    static double tmp = -Double.MAX_VALUE;
    static boolean flag = true;
    class TreeNode {
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
    public void inOrder(TreeNode root){

        if(flag == false) return;
        if(root == null) return;
        inOrder(root.left);
        if(root.val <= tmp) flag = false;
        else {
            tmp = root.val;
        }
        inOrder(root.right);
    }
    public boolean isValidBST(TreeNode root) {
        if(root.left == null && root.right == null) return true;
        flag = true;
        tmp = -Double.MAX_VALUE;
        inOrder(root);
        return flag;
    }
}


