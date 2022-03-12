package easy;

public class num_206 {
    //反转链表
    //头插法
    public ListNode reverseList(ListNode head) {
        if(head==null) {
            return null;
        }
        ListNode point = new ListNode(0) ;
        while(head!=null){
            ListNode temp = head.next,tp=point.next;
            point.next = head;
            head.next=tp;
            head=temp;
        }
        return point.next;
    }
}
