package middle;

import easy.ListNode;

public class num_142 {
    //环形链表
    public ListNode detectCycle(ListNode head) {
        //空间复杂度为1的方法
        if (head == null) {
            return null ;
        }
        ListNode slow = head , fast = head , ptr = null;
        while (fast!=null){
            if(fast.next == null){
                return null;
            }
            fast = fast.next.next ;
            slow = slow.next ;
            if(fast==slow){
                ptr = head ;
                while (ptr != slow){
                    slow = slow.next;
                    ptr= ptr.next;
                }
                break;
            }
        }
        return ptr;
    }
}
