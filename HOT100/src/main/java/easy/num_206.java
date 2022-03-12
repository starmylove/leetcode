package easy;

import medium.ListNode;

public class num_206 {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head ;
        }
        ListNode pre = null ;
        while (head != null){
            ListNode temp = head.next ;
            head.next = pre ;
            pre = head ;
            head = temp ;
        }
        return pre ;
    }
}
