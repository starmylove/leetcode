package medium;

public class num_142 {
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null ;
        }
        ListNode slow = head , fast = head ,ptr = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                while (ptr != slow){
                    ptr = ptr.next ;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }

}
