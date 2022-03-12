package middle;

public class num_148 {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }
        ListNode slow = head , fast = head ;
        while (true){
            fast=fast.next.next;
            if(fast==null||fast.next==null){
                ListNode temp = slow;
                slow = slow.next;
                temp.next=null;
                break;
            }
            slow=slow.next;
        }
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        return merge(left,right);
    }
    public ListNode merge(ListNode headA,ListNode headB){
        ListNode point = new ListNode() , tail = point;
        while (headA!=null||headB!=null){
            if(headA==null){
                tail.next = headB ;
                return point.next ;
            }
            if(headB==null){
                tail.next = headA ;
                return point.next ;
            }
            if(headA.val>=headB.val){
                tail.next=headB;
                tail = headB;
                headB=headB.next;
            }else {
                tail.next=headA;
                tail = headA;
                headA=headA.next;
            }
        }
        return null;
    }
}
