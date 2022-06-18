package Algorithm.LeetCode;
/*
剑指offer ------ 029排序的循环链表
解题思路
插入的值可以分为两种情况考虑：
1.该值比链表中的值都要小，这时该值应该插在最小值的前面或者最大值的后面，显然插在最大值的后面更容易操作。
    比如：4，5，6 ，1，2，3    要插入7，此时7应该插在最大值6的后边
2.链表中存在比该值更小的值，这是该值就应该插在比它小的之中(可能不止一个)最大的一个
   比如：3，5，7，9，1        要插入的值为8
   该链表中比8小的有3，5，7，1，其中最大的为7，所以将8插在7的后边。

 */
public class offer_029 {
    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    };
    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if(head == null){
            node.next = node;
            return node;
        }
        Node cur = head;
        Node maxNode = head;
        Node insertNode = null;
        if(maxNode.val < cur.val){
            maxNode = cur;
        }
        if(cur.val < insertVal && (insertNode == null || insertNode.val <= cur.val)){
            insertNode = cur;
        }
        cur = cur.next;
        while(cur != head){
            if(maxNode.val < cur.val){
                maxNode = cur;
            }
            if(cur.val < insertVal && (insertNode == null || insertNode.val <= cur.val)){
                insertNode = cur;
            }
            cur = cur.next;
        }
        if(insertNode == null){
            node.next = maxNode.next;
            maxNode.next = node;
            return head;
        }
        else{
            node.next = insertNode.next;
            insertNode.next = node;
            return head;
        }
    }
}
