package HashTable;

import java.util.Hashtable;
import java.util.Objects;
import java.util.Scanner;

public class HashTableDemo {

    //哈希表每个位置链表的节点
    class Node{
        int key;
        String value;
        Node next;
        Node(int key, String value){
            this.key = key;
            this.value = value;
            next = null;
        }
        public boolean equals(Node node){
            if(this == node) return true;
            else{
                if(node == null) return false;
                else{
                    return this.value == node.value && this.key == node.key;
                }
            }
        }
    }
    //哈希表的容量
    int size;
    //哈希表存的键值对个数
    int count;
    //加载因子
    static double loadFactor = 0.75;
    //存储数据容器
    Node table[];
    public HashTableDemo(){
        size = 16;
        count = 0;
        table = new Node[size];
        for (int i = 0; i < size; i++) {
            table[i] = new Node(i,null);
        }
    }
    //哈希函数
    public int hashFunc(int key){
        return key % size;
    }


    /*
    添加元素
    思路：
    1.先通过哈希函数算出该键值对在table中的位置。
    2.遍历该处的链表的每一个节点，若发现某节点的key与传入的key相等，那么就更新此处的value。
    3.若未发现相等的key，那么在链表末尾添加新的节点.
    4.最后返回value。
     */
    public String put(int key, String value){
        int index = hashFunc(key);
            Node cur = table[index];
            while(cur.next != null){
                if(cur.next.key == key){
                    cur.next.value = value;
                    break;
                }
                cur = cur.next;
            }
            cur.next = new Node(key, value);
            count++;
        return value;
    }

    /*
    删除元素
    思路：
    1.先通过哈希函数算出该键值对在table中的位置。
    2.遍历该处的链表的每一个节点，若发现某节点的key与传入的key相等，那么就删除此节点，并返回它的value。
    3.若未发现相等的key，返回null。
     */
    public String remove(int key){
        int index = hashFunc(key);
        Node cur = table[index];
        while(cur.next != null){
            if(cur.next.key == key){
                count--;
                String value = cur.next.value;
                cur.next = cur.next.next;
                return value;
            }
            cur = cur.next;
        }
        return null;
    }

    //判断哈希表是否为空
    public boolean isEmpty(){
        for(int i = 0; i < size; i++){
            if(table[i].next != null)
                return false;
        }
        return true;
    }

    //返回哈希表已存数据个数
    public int size(){
        return count;
    }

    //通过key获取value
    public String get(int key){
        int index = hashFunc(key);
        if (table[index].next == null){
            throw new IllegalArgumentException("Illegal key");
        }
        else{
            Node cur = table[index];
            while(cur.next != null){
                if(cur.next.key == key) return cur.next.value;
                cur = cur.next;
            }
        }
        throw new IllegalArgumentException("Illegal key");
    }
    //遍历哈希表
    public void print(){
        for(int i = 0; i < size; i++){
            Node cur = table[i];
            System.out.printf("第%d条链表: ",i);
            if(cur.next == null){
                System.out.println("null");
                continue;
            }
            while(cur.next != null){
                System.out.print(cur.key + "---"+ cur.value + "  ");
                cur = cur.next;
            }
            System.out.println();
        }
    }
}
