package medium;

public class num_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0), p = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int a = l1 != null ? l1.val : 0;
            int b = l2 != null ? l2.val : 0;
            int sum = (a + b + carry);
            p.next = new ListNode(sum % 10);
            carry = sum >= 10 ? 1 : 0;
            p = p.next;
            l1 = l1 != null ? l1.next : null ;
            l2 = l2 != null ? l2.next : null ;
        }
        if (carry == 1) {
            p.next = new ListNode(1);
            p = p.next;
        }
        return head.next;
    }
}
