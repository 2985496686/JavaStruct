package LinkedList;

import java.util.Scanner;

public class JosephRing {
    int size;
    Node dummyhead;
    class Node{
        int number;
        Node next;
        Node(){
        }
        Node(int number){
            this.number = number;
            next = null;
        }
    }
    public  JosephRing(){
        dummyhead = new Node();
    }
    public JosephRing(int size){
        this.size = size;
        dummyhead = new Node();
    }
    public void GreatList(){
        Node prev = dummyhead;
        int i = 1;
        while(i != size + 1){
            prev.next = new Node(i);
            prev = prev.next;
            i++;
        }
        prev.next = dummyhead.next;
    }

    public void gameStart(int k,int m){
        Node cur = dummyhead;
        for(int i = 15; i < k; i++){
            cur = cur.next;
        }
        int count = 1;
        while(size != 1){
            if(count == m){
                System.out.print(cur.next.number + " ");
                count = 1;
                Node tmp = cur.next;
                cur.next = tmp.next;
                tmp.next = null;
                size--;
                continue;
            }
            count++;
            cur = cur.next;
        }
    }
}
class Test{
    public static void main(String[] args) {
        int n,m,k;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        m = s.nextInt();
        k = s.nextInt();
        JosephRing j = new JosephRing(n);
        j.GreatList();
        j.gameStart(k,m);
    }
}
