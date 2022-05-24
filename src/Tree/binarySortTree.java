package Tree;
/*
二叉排序树二叉排序树介绍
二叉排序树:BST: (Binary Sort(Search) Tree),对于二叉排序树的任何一个非叶子节点，
                要求左子节点的值比当前节点的值小，右子节点的值比当前节点的值大。
                对二叉排序树进行中序遍历，结果就是按从小到大排序的

特别说明:如果有相同的值，可以将该节点放在左子节点或右子节点。
 */
public class binarySortTree {
    class Node{
        int value;
        Node left;
        Node right;
        public Node(int value){
            this.value = value;
        }
        public void display(){
            System.out.print(this.value + " ");
        }
    }
    Node root;

    //添加节点
    private void add(Node root,int value){
        //添加节点的值大于根节点的值，该节点添加到根节点的右子树上
        if(value > root.value){
            //根节点的右子树为空，直接添加
            if(root.right == null){
                root.right = new Node(value);
            }
            //根节点右子树不为空，递归往右子树插
            else{
                add(root.right,value);
            }
        }
        //添加节点的值小于或者等于根节点的值，该节点应该添加到左子树
        else{
            //左子树为空，直接添加
            if(root.left == null){
                root.left = new Node(value);
            }
            //左子树不为空，递归往左子树添加
            else{
                add(root.left, value);
            }
        }
    }
    public void add(int value){
        //当前树为空树
        if(root == null){
            root = new Node(value);
            return;
        }
        add(root, value);
    }

    //中序遍历树
    private  void inPrevOrder(Node root){
        if(root == null) return;
        inPrevOrder(root.left);
        root.display();
        inPrevOrder(root.right);
    }
    public void inPrevOrder(){
        System.out.print("中序遍历：");
        inPrevOrder(root);
    }

    /**
     * 通过value查找二叉树中的节点
     * @param root 被查找树的根节点
     * @param value 要查找的值
     * @return 返回查找到的节点
     */
    private Node searchNode(Node root, int value){
        //被查找树为null，要查找节点不存在
        if(root == null)
            return null;
        //找到了，返回节点
        else if(root.value == value){
            return root;
        }
        //该节点不是要查找节点，继续查找
        else{
            //该节点的值大于value，往该节点的左子树递归查找
            if(root.value > value){
                return searchNode(root.left, value);
            }
            //该节点的值小于value,往该节点的右子树递归查找
            else{
                return searchNode(root.right, value);
            }
        }
    }

    /**
     * 查找某节点的父节点，并返回
     * @param root 被查找树的根节点
     * @param node 要查找的节点
     * @return 返回被查找节点的父节点
     */
    private Node searchParentNode(Node root, Node node){
        //被查找树为null或者根节点就是要查找的节点，那么要查找节点的父节点不存在
        if(root == null || root.value == node.value) return null;
        else if(root.left.value == node.value || root.right.value == node.value){
            return root;
        }
        else{
            if(root.value > node.value){
                return searchParentNode(root.right, node);
            }
            else{
                return searchParentNode(root.left, node);
            }
        }
    }

    /*
    排序二叉树的删除
    二叉排序树的删除情况比较复杂，有下面三种情况需要考虑
    1)删除叶子节点
    2)删除只有一颗子树的节点
    3)删除有两颗子树的节点


   第一种情况：删除的节点是叶子节点


   第二种情况:删除只有一颗子树的节点
(1)需求先去找到要删除的结点targetNode
(2)找到targetNode的父结点parent
(3)确定targetNode的子结点是左子结点还是右子结点
(4) targetNode是parent的左子结点还是右子结点
(5)如果targetNode有左子结点
   5.1如果targetNode是parent的左子结点parent.left = targetNode.left;
   5.2如果targetNode是parent的右子结点parent.right = targetNode.left;
(6)如果targetNode有右子结点
   6.1如果targetNode是 parent 的左子结点parent.left = targetNode.right;
   6.2如果targetNode是parent 的右子结点parent.right = targetNode.right

    第三种情况：删除的节点有左右两个子树
(1)需求先去找到要删除的结点targetNode
(2)在右子树找到最小的节点，用一个temp保存这个节点的值，然后删除这个最小节点(该最小节点一定是满足第一种情况的)
(3)targetNode.value = temp
*/


    public void remove(int vlaue){
        //找到要删除的节点
        Node targetNode = searchNode(root,vlaue);
        //找到要删除节点的父节点
        Node targetNodeParet = searchParentNode(root,targetNode);
        //要删除节点不存在
        if(targetNode == null) return;
        //要删除节点为叶子节点
        else if(targetNode.left == null && targetNode.right == null){
            //要删除的节点就是根节点
            if(targetNodeParet == null){
              root = targetNode;
            }
            else{
                //要删除节点是其父节点的左节点
                if(targetNodeParet.left.value == targetNode.value){
                    targetNodeParet.left = null;
                }
                else{
                    targetNodeParet.right = null;
                }
            }
        }
        //要删除节点只有一个左子树
        else if(targetNode.left != null && targetNode.right == null){
            //要删除的节点就是根节点
            if(targetNodeParet == null) {
                root = root.left;
                return;
            }
            //要删除节点是其父节点的左节点
            else if(targetNodeParet.left != null && targetNodeParet.left.value == targetNode.value){
                targetNodeParet.left = targetNode.left;
            }
            //要删除节点是其父节点的右节点
            else{
                targetNodeParet.right = targetNode.left;
            }
        }
        //要删除节点只有一个右子树
        else if(targetNode.right != null && targetNode.left == null){
            //要删除的节点就是根节点
            if(targetNodeParet == null) {
                root = root.right;
                return;
            }
            //要删除节点是其父节点的左节点
            else if(targetNodeParet.left != null && targetNodeParet.left.value == targetNode.value){
                targetNodeParet.left = targetNode.right;
            }
            //要删除节点是其父节点的右节点
            else{
                targetNodeParet.right = targetNode.right;
            }
        }
        //要删除节点右左右都有节点
        else{
            //找到右子树最小的节点
            Node minNode = targetNode.right;
            while(minNode.left != null){
                minNode = minNode.left;
            }
            int temp = minNode.value;
            Node minNodeParent = searchParentNode(targetNode.right,minNode);
            if(minNodeParent == null){
                root = targetNode;
            }
            else{
                //要删除节点是其父节点的左节点
                if(targetNodeParet.left.value == targetNode.value){
                    targetNodeParet.left = null;
                }
                else{
                    targetNodeParet.right = null;
                }
            }

            targetNode.value = temp;
        }
    }

    public static void main(String[] args) {
        binarySortTree tree = new binarySortTree();
        tree.add(10);
        tree.add(3);
        tree.add(7);
        tree.add(12);
        tree.add(5);
        tree.add(1);
        tree.add(9);
        tree.remove(9);
        tree.inPrevOrder();
    }
}

