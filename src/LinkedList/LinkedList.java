package LinkedList;

public class LinkedList<E> {

    class Node<E>{
        //所存储元素
        E e;
        //指向下一个节点的引用
        Node<E> next;
        Node(E e,Node<E> next){
            this.e = e;
            this.next = next;
        }
        Node(){
            this(null,null);
        }
        public Node(E e){
            this.e = e;
        }
        public String toString(){
            return e.toString();
        }
    }
    //链表中的元素个数
    private int size;
    //虚拟头节点
    private Node<E> dummyhead;
    //LinkedList的构造器
    public LinkedList(){
        size = 0;
        dummyhead = new Node<E>(null);
    }


    //获取链表长度
    public int getSize(){
        return size;
    }


    //判断链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //在索引处添加元素(对头至队尾)
    public void add(E e,int Index){
        if(Index < 0 || Index > size){
            throw new IllegalArgumentException("Add fail. Illegal index");
        }
        Node<E> prev = dummyhead;
        for(int i = 0; i < Index; i++){
            prev = prev.next;
        }
        Node<E> newNode = new Node<E>(e,prev.next);
        prev.next = newNode;
        size++;
    }

    //在链表头添加元素
    public void addFirst(E e){
        add(e,0);
    }

    //在链表尾添加元素
    public void addLast(E e){
        add(e,size);
    }



    //删除索引处的元素,并返回
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Remove fail. Illegal index.");
        }
        Node<E> prev = dummyhead;
        for(int i = 0; i < index; i++){
            prev = prev.next;
        }
        Node<E> retNode = prev.next;
        prev.next = retNode.next;
        size--;
        return retNode.e;
    }


    //删除链表头元素，并返回
    public E removeFirst(){
        return remove(0);
    }

    //删除链表尾部元素，并返回
    public E removeLast(){
        return remove(size - 1);
    }

    //获得索引处的元素
    public E get(int index){
        if(index < 0 || index >= index){
            throw new IllegalArgumentException("Get fail. Illegal index");
        }
        Node<E> cur = dummyhead.next;
        for(int i = 0; i < index; i++){
            cur = cur.next;
        }
        return cur.e;
    }

    //获得链表头部元素
    public E getFirst(){
        return get(0);
    }


    //获得链表尾部元素
    public E getLast(){
        return get(size - 1);
    }

    //修改索引处元素
    public void set(int index, E e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Set fail. Illegal index");
        }
        Node<E> cur = dummyhead;
        for(int i = 0; i < index; i++){
            cur = cur.next;
        }
        cur.e = e;
    }

    //查找链表中是否包含元素 e
    public boolean contains(E e){
        Node<E> cur = dummyhead.next;
        while(cur.next != null){
            if(cur.e.equals(e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //删除链表中的元素e
    public void removeElement(E e){
        Node<E> prev = dummyhead.next;
        while(prev.next != null){
            if(prev.next.e.equals(e)){
              break;
            }
            prev = prev.next;
        }

        if(prev.next != null){
            Node<E> delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
        }
    }

    //寻找链表中点
    public Node<E> findMidpoint(){
        if(dummyhead.next == null){
            return null;
        }
        Node<E> fast = dummyhead.next;
        Node<E> slow = dummyhead.next.next;
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
            if(fast != null){
                fast = fast.next;
            }
        }
        return slow;
    }


    //返回索引处的节点
    public Node<E> getNode(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("GetNode fail. Illegal index");
        }
        Node<E> cur = dummyhead.next;
        for(int i = 0; i < index; i++){
            cur = cur.next;
        }
        return cur;
    }


    //反转链表 —— 三指针法
    public Node<E> reverse1(Node<E> head){
        if(head == null) return null;
        Node<E> p = head;
        Node<E> q = p.next;
        Node<E> tmp = null;
        p.next = null;
        while(q != null){
            tmp = q;
            q = q.next;
            tmp.next = p;
            p = tmp;
        }
        dummyhead.next = p;
        return dummyhead.next;
    }





    //递归法实现链表逆序
    public  Node<E> reverse2(Node<E> head){
        if(head == null || head.next == null) {
            dummyhead.next = head;
            return head;
        }
        Node<E> next = head.next;
        reverse2(next);
        next.next = head;
        head.next = null;
        return dummyhead.next;
    }


    //打印链表元素
    public void printList(){
        Node<E> cur = dummyhead.next;
        while(cur != null){
            System.out.print(cur.e + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
class test{
    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        l.addLast(1);
        l.addLast(2);
        l.addLast(3);
        l.addLast(4);
        l.reverse2(l.getNode(0));
        l.reverse2(l.getNode(0 ));
        l.printList();

    }
}