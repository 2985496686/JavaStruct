package Algorithm.LeetCode;

/*
力扣：96. 不同的二叉搜索树
思路：动态规划，n个节点所能组成的不同的搜索二叉树为g(n)
以 n = 5为例：
            n = 5 所能组成的不同搜索二叉树数量等于下面几种情况之和：
            （1）以1为根，左子树为null(没有节点)， 右子树为2，3，4(三个节点)组成的二叉树，数量为g(0)*g(3)
            （2）以2为根，左子树为1(1个节点)， 右子树为3，4(两个节点)组成的二叉树，数量为g(1)*g(2)
            （3）以3为根，左子树为1，2(两个节点)， 右子树为 4(一个节点)， 组成的二叉树，数量为g(2)*g(1)
            （4）以4为根，左子树为1,2,3(三个节点)， 右子树为null(没有节点)组成的二叉树，数量为g(3)*g(0)
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int arr[] = new int[n + 2];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;
        for(int i = 3; i <= n; i++){
            int p = 0;
            int q = i - 1;
            for(; q >= 0; ){
                arr[i] += arr[p]*arr[q];
                p++;
                q--;
            }
        }
        return arr[n];
    }
}
