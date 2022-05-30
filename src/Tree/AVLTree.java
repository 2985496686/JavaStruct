/*
1)平衡二叉树也叫平衡二叉搜索树(Self-balancing binary search tree）又被称为AVL树，
是在二叉搜索树的基础上实现的(BST的优化)，可以保证查询效率较高。

2)具有以下特点:它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。

3)平衡二叉树的常用实现方法有红黑树、AVL、替罪羊树、Treap、伸展树等。
 */
package Tree;
public class AVLTree <E extends Comparable<E>>{
    class Node{
        E value;
        Node left;
        Node right;
        int height;
        public Node(){}
        public Node(E value){
            this.value = value;
            height = 1;
            left = null;
            right = null;
        }
        public void display(){
            System.out.print(this.value + " ");
        }
    }
    Node root;
    int size;
    public int getHeight(Node node) {
        if(node == null) return 0;
        return node.height;
    }
    //获取平衡因子(左右子树的高度差，大小为1或者0是平衡的，大小大于1不平衡)
    public int getBalanceFactor(){
        return getBalanceFactor(root);
    }
    public int getBalanceFactor(Node node){
        if(node == null) return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    //判断一个树是否是一个平衡二叉树
    public boolean isBalance(Node node){
        if(node == null) return true;
        int balanceFactor = Math.abs(getBalanceFactor(node.left) - getBalanceFactor(node.right));
        if(balanceFactor > 1) return false;
        return isBalance(node.left) && isBalance(node.right);
    }
    public boolean isBalance(){
        return isBalance(root);
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

    //左旋,并且返回新的根节点
    public Node leftRotate(Node node){
        System.out.println("leftRotate");
       Node cur = node.right;
       node.right = cur.left;
       cur.left = node;
       //跟新node和cur的高度
        node.height = Math.max(getHeight(node.left),getHeight(node.right)) + 1;
        cur.height = Math.max(getHeight(cur.left),getHeight(cur.right)) + 1;
        return cur;
    }

    //右旋，并且返回新的根节点
    public Node rightRotate(Node node){
        System.out.println("rightRotate");
        Node cur = node.left;
        node.left = cur.right;
        cur.right = node;
        //跟新node和cur的高度
        node.height = Math.max(getHeight(node.left),getHeight(node.right)) + 1;
        cur.height = Math.max(getHeight(cur.left),getHeight(cur.right)) + 1;
        return cur;
    }

    //添加元素
    public  void add(E e){
        root = add(root,e);
    }
    public Node add(Node node, E value) {
        if (node == null) {
            size++;
            return new Node(value);
        }
        if (value.compareTo(node.value) > 0) {
            node.right = add(node.right, value);
        } else if (value.compareTo(node.value) < 0) {
            node.left = add(node.left, value);
        }
        //跟新节点高度
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        //获取当前节点的平衡因子
        int balanceFactor = getBalanceFactor(node);
        //该子树不平衡且新插入节点(导致不平衡的节点)在左子树的左子树上，此时需要进行右旋
        if (balanceFactor > 1 && getBalanceFactor(node.left) > 0) {
            return rightRotate(node);
        }
        //该子树不平衡且新插入节点(导致不平衡的节点)在右子树子树的右子树上，此时需要进行左旋
        else if (balanceFactor < -1 && getBalanceFactor(node.right) < 0) {
            return leftRotate(node);
        }
        //该子树不平衡且新插入节点(导致不平衡的节点)在左子树的右子树上，此时需要先对左子树左旋，在整个树右旋
        else if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        //balanceFactor < -1 && getBalanceFactor(node.left) > 0
        //该子树不平衡且新插入节点(导致不平衡的节点)在右子树的左子树上，此时需要先对右子树右旋，再整个树左旋
        else if(balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }


    //删除节点
    public E remove(E value){
        root = remove(root,value);
        if(root == null){
            return null;
        }
        return root.value;
    }
    public Node remove(Node node, E value){
        Node retNode = null;
        if(node == null)
            return retNode;
        if(value.compareTo(node.value) > 0){
            node.right = remove(node.right,value);
            retNode = node;
        }
        else if(value.compareTo(node.value) < 0){
            node.left = remove(node.left,value);
            retNode = node;
        }
        //value.compareTo(node.value) = 0
        else{
            //左右节点都为空，或者左节点为空
            if(node.left == null){
                size--;
                retNode = node.right;
            }
            //右节点为空
            else if(node.right == null){
                size--;
                retNode = node.left;
            }
            //左右节点都不为空
            else{
                Node successor = new Node();
                //寻找右子树最小的节点
                Node cur = node.right;
                while(cur.left != null){
                    cur = cur.left;
                }
                successor.value  = cur.value;
                successor.right = remove(node.right,value);
                successor.left = node.left;
                node.left =  node.right = null;
                retNode = successor;
            }
            if(retNode == null)
                return null;
            //维护二叉树平衡
            //跟新height
            retNode.height = Math.max(getHeight(retNode.left),getHeight(retNode.right));
        }
        int balanceFactor = getBalanceFactor(retNode);
        //该子树不平衡且新插入节点(导致不平衡的节点)在左子树的左子树上，此时需要进行右旋
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) >= 0) {
            return rightRotate(retNode);
        }
        //该子树不平衡且新插入节点(导致不平衡的节点)在右子树子树的右子树上，此时需要进行左旋
        else if (balanceFactor < -1 && getBalanceFactor(retNode.right) <= 0) {
            return leftRotate(retNode);
        }
        //该子树不平衡且新插入节点(导致不平衡的节点)在左子树的右子树上，此时需要先对左子树左旋，在整个树右旋
        else if (balanceFactor > 1 && getBalanceFactor(retNode.left) < 0) {
            retNode.left = leftRotate(retNode.left);
            return rightRotate(retNode);
        }
        //该子树不平衡且新插入节点(导致不平衡的节点)在右子树的左子树上，此时需要先对右子树右旋，再整个树左旋
        else if(balanceFactor < -1 && getBalanceFactor(retNode.right) > 0) {
            retNode.right = rightRotate(retNode.right);
            return leftRotate(retNode);
        }
        return  retNode;
    }
    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>();
        tree.add(5);
        tree.add(3);
        tree.add(6);
        tree.add(4);
        tree.add(2);
        tree.remove(6);

        System.out.println(tree.getBalanceFactor());
        tree.inPrevOrder();

    }
}
