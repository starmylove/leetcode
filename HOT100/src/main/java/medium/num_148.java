package medium;

import java.util.List;

public class num_148 {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head ;
        }
        ListNode slow = head , fast = head.next ;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next ;
        slow.next = null ;
        return sortTwoSotedList(sortList(head),sortList(head2));
    }
    public ListNode sortTwoSotedList(ListNode l1 , ListNode l2){
        ListNode head = new ListNode() ,tail = head;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                tail.next =  l1 ;
                tail = tail.next ;
                l1 = l1.next ;
            }else {
                tail.next = l2 ;
                tail = tail.next ;
                l2 = l2.next ;
            }
        }
        if(l1 != null){
            tail.next = l1 ;
        }
        if(l2 != null){
            tail.next = l2;
        }
        return head.next ;
    }
}
