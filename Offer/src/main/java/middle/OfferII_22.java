package middle;

import com.sun.corba.se.spi.orbutil.fsm.FSM;

public class OfferII_22 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head , fast = head ;
        do{
            if(fast==null || fast.next==null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }while (slow!=fast);
        fast = head;
        while (slow != fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}
