package easy;

public class Offer_22 {
    //剑指 Offer 22. 链表中倒数第k个节点
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode left = head , right = head;
        for (int i = 0; i < k ; i++) {
            right = right.next;
        }
        while (right!=null){
            right = right.next;
            left = left.next;
        }
        return left;
    }
}
