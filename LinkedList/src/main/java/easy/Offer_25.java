package easy;

public class Offer_25 {
    //剑指 Offer 25. 合并两个排序的链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode point = new ListNode(0) , tail = point;
        while(l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                tail.next=l1;
                l1=l1.next;
                tail = tail.next;
            }else{
                tail.next = l2;
                l2=l2.next;
                tail = tail.next;
            }
        }
        if(l1==null) {
            tail.next = l2;
        } else {
            tail.next = l1;
        }
        return point.next;
    }
}


