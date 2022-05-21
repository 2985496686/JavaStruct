package Queue;

public class ArrayQueue {
    //队列
    private int []queue;
    //队列头和尾
    private int front;
    private int rear;
    private int capacity;
    //构造方法
    //默认初始化容量为0
    public ArrayQueue(){
        this.queue =  new int[10];
        this.capacity = 10;
        front = rear = -1;
    }
    public  ArrayQueue(int capacity){
        this.queue = new int[capacity];
        front = rear = -1;
        this.capacity = capacity;
    }

    //进队列
    public void queueAdd(int data){
        if(rear + 1 == capacity){
            System.out.println("队列已满，添加失败！");
            return;
        }
        queue[++rear] = data;
    }

    //出队列
    public void queuePop(){
        if(isEmpty()){
            System.out.println("队列为空，出队列失败！");
            return;
        }
        front++;
    }

    //队列判空
    public boolean isEmpty(){
        if(rear == front){
            return true;
        }
        else
            return false;
    }

    //获取对头元素
    public int queueFront(){
        if(isEmpty())
        {
            throw new RuntimeException("队列为空！");
        }
        else
        {
            return queue[front+1];
        }
    }
}
class Test{
    public static void main(String[] args) {
        ArrayQueue q = new ArrayQueue();
        q.queuePop();
        //q.queueFront();
        q.queueAdd(12);
        q.queueAdd(13);
        q.queueAdd(14);
        q.queueAdd(12);
        q.queueAdd(13);
        q.queueAdd(14);
        q.queueAdd(12);
        q.queueAdd(13);
        q.queueAdd(14);
        q.queueAdd(17);
        q.queueAdd(15);
        System.out.println("是否为空："+ q.isEmpty());
        q.queuePop();
        q.queuePop();
        q.queuePop();
        q.queuePop();
        q.queuePop();
        q.queuePop();
        q.queuePop();
        q.queuePop();
        q.queuePop();
        q.queuePop();
        q.queuePop();
        q.queuePop();
        System.out.println("是否为空："+ q.isEmpty());
    }

}