package hard;

import easy.ListNode;

public class num_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null) {
            return null;
        }
        ListNode point = new ListNode(0);
        point.next=head;
        ListNode p = point;
        while (containKElements(p,k)){
            //头插法 维护两个链表，一个是原链表，一个是新链表，不断地将原链表的首元素删除并插入到新链表的头部
            ListNode oldHead , newHead,newTemp=p.next;
            oldHead = p.next;
            newHead = new ListNode(0);
            for (int i = 0; i < k; i++) {
                ListNode temp = newHead.next;
                newHead.next = oldHead;
                oldHead = oldHead.next;
                newHead.next.next=temp;
            }
            newTemp.next = oldHead;
            p.next = newHead.next;
            p=newTemp;
        }
        return point.next;
    }
    public boolean containKElements(ListNode p, int k){
        ListNode tmp = p;
        while(k!=0){
            tmp=tmp.next;
            if(tmp==null) {
                return false;
            }
            k--;
        }
        return true;
    }
}
