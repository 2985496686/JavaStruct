package Algorithm.Assessment;

public class isHuiWen {
    class ListNode{
        int val;
        ListNode next;
        public ListNode(){};
        public ListNode(int val){
            this.val = val;
        }
    }
    public boolean isPalindrome(ListNode head){
        if(head == null || head.next == null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
            if(fast != null){
                fast = fast.next;
            }
        }
        ListNode p = slow;
        ListNode q = slow.next;
        ListNode cur = null;
        p.next = null;
        while(q != null){
            cur = q;
            q = q.next;
            cur.next = p;
            p = cur;
        }
        ListNode head2 = p;
        while(head!=null &&head2 != null){
            if(head.val != head2.val) return false;
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}

