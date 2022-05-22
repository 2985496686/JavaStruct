package HashTable;

public class HashTableDemo {

        //哈希表每个位置链表的节点
        class Node{
            int key;
            String value;
            Node next;
            Node(){
            }
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
        //哈希表的长度
        int length;
        //哈希表存的键值对个数
        int size;
        //加载因子
        static double loadFactor = 0.75;
        //存储数据容器
        Node table[];
        public HashTableDemo(){
            length = 16;
            size = 0;
            table = new Node[length];
            for (int i = 0; i < length; i++) {
                table[i] = new Node(i,null);
            }
        }
        public HashTableDemo(int length){
            this.length = length;
            size = 0;
            table = new Node[length];
            for (int i = 0; i < length; i++) {
                table[i] = new Node(i,null);
            }
        }
    //哈希函数
    public int hashFunc(int key){
        return key % length;
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
            //保证cur2始终是cur的前一个节点。
            Node cur = table[index].next;
            Node cur2 = table[index];
            while(cur != null){
                if(cur.key == key){
                    cur.value = value;
                    return value;
                }
                cur = cur.next;
                cur2 = cur2.next;
            }
            cur2.next = new Node(key, value);
            size++;
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
                size--;
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
        for(int i = 0; i < length; i++){
            if(table[i].next != null)
                return false;
        }
        return true;
    }

    //返回哈希表已存数据个数
    public int size(){
        return size;
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
        for(int i = 0; i < length; i++){
            Node cur = table[i];
            System.out.printf("第%d条链表: ",i);
            if(cur.next == null){
                System.out.println("null");
                continue;
            }
            cur = cur.next;
            while(cur != null){
                System.out.print(cur.key + "---"+ cur.value + "  ");
                cur = cur.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        HashTableDemo h = new HashTableDemo();
        h.put(12,"张三");
        h.put(14,"李四");
        h.put(124,"张三");
        h.put(122,"张三");
        h.put(1455,"李四");
        h.put(1224,"张三");
        h.put(143,"李四");
        h.put(5,"kkk");
        h.put(21,"2222222");
        h.put(1455,"李四");
        h.put(1455,"李ffffff");
        h.print();
        h.remove(1455);
        h.remove(5);
        h.print();
        System.out.println(h.size());
    }
}
