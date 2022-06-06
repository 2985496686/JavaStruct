package Algorithm.Assessment;
/*

 */
public class MyQueue {
    class Node{
        int val;
        Node next;
        public Node(){};
        public Node(int val){
            this.val = val;
            next = null;
        }
    }
    Node tail;
    Node head;
    public boolean isEmpty(){
        if(head == null)
            return true;
        return false;
    }
    public void offer(int val){
        if(head == null){
            tail = head = new Node(val);
        }
        else{
            tail.next = new Node(val);
            tail = tail.next;
        }

    }
    public int poll(){
        int rnt;
        if(head == null){
            throw new IllegalArgumentException("队列为空，出队列失败！");
        }
        else if(head == tail){
            rnt = head.val;
            tail = head = null;
        }
        else{
            rnt = head.val;
            head = head.next;
        }
        return rnt;
    }

    public static void main(String[] args) {
        MyQueue m = new MyQueue();
        m.offer(1);
        m.offer(2);
        m.offer(3);
        m.offer(4);
        System.out.println(m.poll());
        System.out.println(m.poll());
        System.out.println(m.poll());
        System.out.println(m.poll());
    }
}
