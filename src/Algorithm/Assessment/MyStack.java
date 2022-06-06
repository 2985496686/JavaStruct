package Algorithm.Assessment;

public class MyStack {
    int tail;
    int[] stack;
    public MyStack(){
        tail = 0;
        stack = new int[100];
    }
    public void push(int val){
        stack[tail] = val;
        tail++;
    }
    public int pop(){
        if(tail == 0){
            throw new IllegalArgumentException("栈为空，无法出栈！");
        }
        tail--;
        int tmp = stack[tail];
        return tmp;
    }
    public void clear(){
        tail = 0;
    }

    public static void main(String[] args) {
        MyStack m = new MyStack();
        m.push(1);
        m.push(2);
        m.push(3);
        m.push(4);
        System.out.println(m.pop());
        System.out.println(m.pop());
        System.out.println(m.pop());
        System.out.println(m.pop());
        System.out.println(m.pop());
    }
}
