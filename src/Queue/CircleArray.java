package Queue;

import java.util.Scanner;

public class CircleArray {
    private int front;
    private int rear;
    private int capacity;
    int []queue;

    //构造器
    public CircleArray(){
        front = 0;
        rear = 0;
        capacity = 10;
        queue = new int[capacity];
    }
    public CircleArray(int capacity){
        front  = 0;
        rear = 0;
        this.capacity = capacity;
        queue = new int[capacity];
    }
    //判断队列是否已满
    public boolean isFull(){
        return (rear + 1) % capacity == front;
    }

    //判空
    public boolean isEmpty(){
        return (rear + capacity - front) % capacity == 0;
    }

    //入队列
    public void queueAdd(int x){
        if(isFull()){
            throw new RuntimeException("队列已满，不能入队列！");
        }
        queue[rear] = x;
        //会空一个位置
        rear = (rear + 1) % capacity;
    }

    //取数据
    public int queueFront(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，无法取数据！");
        }
        return queue[front];
    }
    //出队列
    public int queuePop(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，不能出队列！");
        }
        int value = queue[front];
        front = (front + 1) % capacity;
        return value;
    }
    //获取队列有效数据的个数
    public int queueSize(){
        return (rear + capacity - front) % capacity;
    }

    //显示队列数据
    public void showQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，无法显示数据！");
        }
        int tmp = front;
        for(int i = 0; i < queueSize(); i++){
            System.out.print(queue[tmp] + " ");
            tmp = (tmp + 1) % capacity;
        }
    }
}
class Test01{
    public static void main(String[] args) {
        CircleArray c = new CircleArray(5);
        System.out.println("a:isFull");
        System.out.println("b:isEmpty");
        System.out.println("c:queueAdd");
        System.out.println("d:queueFront");
        System.out.println("e:queuePop");
        System.out.println("f:queueSize");
        System.out.println("g:showQueue");
        Scanner scanner  = new Scanner(System.in);
        while(true){
            char k = scanner.next().charAt(0);
            switch(k){
                case 'a':
                    System.out.println(c.isFull());
                    break;
                case 'b':
                    System.out.println(c.isEmpty());
                    break;
                case 'c':
                    try{
                        c.queueAdd(scanner.nextInt());
                    }catch(RuntimeException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'd':
                    try{
                        System.out.println("对头数据为：" + c.queueFront());
                    }catch(RuntimeException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    try{
                        System.out.println(c.queuePop() + "已被出队列！");
                    }catch(RuntimeException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'f':
                    System.out.println(c.queueSize());
                    break;
                case 'g':
                        try{
                            c.showQueue();
                        }catch(RuntimeException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                default:
                        break;


            }
        }
    }
}
