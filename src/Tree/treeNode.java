package Tree;

public class treeNode {
    String value;
    treeNode left;
    treeNode right;
    public treeNode(){}
    public treeNode(String value){
        this.value = value;
        this.right = null;
        this.left = null;
    }
    public void display(){
        System.out.print(this.value + " ");
    }
}
