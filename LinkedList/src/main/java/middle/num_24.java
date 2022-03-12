package middle;

import easy.ListNode;

public class num_24 {
    /*
    * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
    你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
    * */
    public ListNode swapPairs(ListNode head) {
        if(head==null) {
            return null;
        }
        ListNode point = new ListNode(0);
        point.next=head;
        ListNode p = point;
        while (p.next!=null&&p.next.next!=null){
            ListNode t1 = p.next;
            ListNode t2 = p.next.next.next;
            p.next = t1.next;
            t1.next.next = t1 ;
            t1.next = t2;
            p=p.next.next;
            if(p==null) {
                break;
            }
        }
        return point.next;
    }
}

