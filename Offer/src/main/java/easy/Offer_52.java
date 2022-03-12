package easy;

import java.util.List;

public class Offer_52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int la = 0 , lb = 0 ;
        ListNode p1 = headA , p2 = headB ;
        while (p1 != null){
            la++;
            p1 = p1.next;
        }
        while (p2 != null){
            lb++;
            p2 = p2.next;
        }
        int res = Math.abs(la - lb);
        if(la>lb){
            for (int i = 0; i < res; i++) {
                headA = headA.next;
            }
        }else {
            for (int i = 0; i < res; i++) {
                headB = headB.next;
            }
        }
        while (headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}

