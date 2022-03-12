package easy;

import medium.ListNode;

public class num_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0 , lenB = 0 ;
        ListNode cur = headA ;
        while (cur != null){
            lenA ++ ;
            cur = cur.next;
        }
        cur = headB ;
        while (cur != null){
            lenB ++ ;
            cur = cur.next;
        }
        if(lenA > lenB){
            for (int i = 0; i < lenA - lenB; i++) {
                headA = headA.next ;
            }
        }else {
            for (int i = 0; i < lenB - lenA; i++) {
                headB = headB.next ;
            }
        }
        while (headA != headB ){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null ;
        }
        ListNode p1 = headA , p2 = headB ;
        while (p1 != p2){
            p1 = p1 == null ? headB : p1.next ;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1 ;
    }
}
